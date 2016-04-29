package kz.theeurasia.policy.services.impl;

import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Singleton;

import kz.theeurasia.policy.domain.InsuredDriverData;
import kz.theeurasia.policy.domain.InsuredVehicleData;
import kz.theeurasia.policy.domain.PolicyTermClass;
import kz.theeurasia.policy.services.CalculationService;
import kz.theeurasia.policy.services.PremiumCostCalculatorRatesService;

@Default
@Singleton
public class CalculationServiceDefault implements CalculationService {

    @Inject
    private PremiumCostCalculatorRatesService rates;

    @Override
    public double calculatePremiumCost(List<InsuredDriverData> drivers, List<InsuredVehicleData> vehicles,
	    PolicyTermClass termClass) {
	double maximumCost = 0d;
	for (InsuredDriverData driver : drivers)
	    for (InsuredVehicleData vehicle : vehicles) {
		double cost = _calculatePremiumCostVariant(driver, vehicle, termClass);
		if (cost == 0) {
		    return 0;
		}
		if (maximumCost < cost)
		    maximumCost = cost;
	    }
	return maximumCost;
    }

    private double _calculatePremiumCostVariant(InsuredDriverData insured, InsuredVehicleData vehicle,
	    PolicyTermClass policyTermClass) {
	double premium = rates.getBase();
	premium *= rates.getBaseRate();
	premium *= rates.getRegionRate(vehicle.getVehicleCertificateData().getRegion());
	premium *= rates.getIsMajorKZCityCorrectionRate(vehicle.getVehicleCertificateData().getCity());
	premium *= rates.getVehicleTypeRate(vehicle.getVehicleClass());
	premium *= rates.getDriverExpirienceTypeRate(insured.getAgeClass(), insured.getExpirienceClass());
	premium *= rates.getVehicleAgeTypeRate(vehicle.getVehicleAgeClass());
	premium *= rates.getInsuranceClassTypeRate(insured.getInsuranceClassType());
	premium *= rates.getPolicyTermClassRate(policyTermClass);
	premium *= rates.getPrivilegeRate(insured.isHasAnyPrivilege());
	premium = roundMoney(premium); // округляем до "копеек"
	return premium;
    }

    private static double roundMoney(final double input) {
	double output = input;
	output *= 100d;
	output = Math.round(output);
	output /= 100d;
	return output;
    }
}
