package kz.theeurasia.services.services.impl;

import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Singleton;

import kz.theeurasia.services.domain.osgpovts.InsuredInfo;
import kz.theeurasia.services.domain.osgpovts.PolicyTermClass;
import kz.theeurasia.services.domain.osgpovts.VehicleInfo;
import kz.theeurasia.services.services.OSGPOVTSCalculator;
import kz.theeurasia.services.services.OSGPOVTSRates;

@Singleton
public class OSGPOVTSCalculatorImplementation implements OSGPOVTSCalculator {

    @EJB
    private OSGPOVTSRates rates;

    private Logger logger = Logger.getAnonymousLogger();

    private double _calculatePremiumVariant(InsuredInfo insuredInfo, VehicleInfo vehicleInfo,
	    PolicyTermClass policyTermClass) {
	double premium = rates.getBase();
	premium = premium * rates.getBaseRate();
	premium = premium * rates.getRegionRate(vehicleInfo.getVehicleRegion());
	premium = premium * rates.getIsMajorCityCorrectionRate(vehicleInfo.isMajorCity());
	premium = premium * rates.getVehicleTypeRate(vehicleInfo.getVehicleType());
	premium = premium
		* rates.getDriverExpirienceTypeRate(insuredInfo.getInsuredAgeClass(),
			insuredInfo.getDriverExpirienceClass());
	premium = premium * rates.getVehicleAgeTypeRate(vehicleInfo.getVehicleAgeType());
	premium = premium * rates.getInsuranceClassTypeRate(insuredInfo.getInsuranceClassType());
	premium = premium * rates.getPolicyTermClassRate(policyTermClass);
	premium = premium * rates.getPrivilegeRate(insuredInfo.isHasPrivilege());
	premium = Math.round(premium * 100) / 100; // округляем до "копеек"
	return premium;
    }

    @Override
    public double calculatePremium(InsuredInfo[] insuredInfos, VehicleInfo vehicleInfo,
	    PolicyTermClass policyTermClass) {
	double maxPremium = 0d;
	for (InsuredInfo insuredInfo : insuredInfos) {
	    double premium = _calculatePremiumVariant(insuredInfo, vehicleInfo, policyTermClass);
	    if (premium > maxPremium)
		maxPremium = premium;
	}
	logger.fine("Calculated premium cost " + maxPremium);
	return maxPremium;
    }

    @Override
    public double calculatePremium(InsuredInfo insuredInfo, VehicleInfo[] vehicleInfos,
	    PolicyTermClass policyTermClass) {
	double maxPremium = 0d;
	for (VehicleInfo vehicleInfo : vehicleInfos) {
	    double premium = _calculatePremiumVariant(insuredInfo, vehicleInfo, policyTermClass);
	    if (premium > maxPremium)
		maxPremium = premium;
	}
	logger.fine("Calculated premium cost " + maxPremium);
	return maxPremium;
    }
}
