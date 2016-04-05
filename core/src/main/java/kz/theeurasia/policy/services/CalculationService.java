package kz.theeurasia.policy.services;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import kz.theeurasia.policy.domain.InsuredDriverData;
import kz.theeurasia.policy.domain.InsuredVehicleData;
import kz.theeurasia.policy.domain.PolicyTermClass;

@Named
@ApplicationScoped
public class CalculationService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private PremiumCostCalculatorRatesService rates;

    public double calculatePremiumCost(List<InsuredDriverData> drivers, List<InsuredVehicleData> vehicles,
	    PolicyTermClass termClass) {
	return calculatePremiumCost(drivers, vehicles, termClass, false);
    }

    public double calculatePremiumCost(List<InsuredDriverData> drivers, List<InsuredVehicleData> vehicles,
	    PolicyTermClass termClass, boolean rounded) {
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
	if (rounded)
	    maximumCost = Math.round(maximumCost);
	return maximumCost;
    }

    private double _calculatePremiumCostVariant(InsuredDriverData insured, InsuredVehicleData vehicle,
	    PolicyTermClass policyTermClass) {
	double premium = rates.getBase();
	premium = premium * rates.getBaseRate();
	premium = premium * rates.getRegionRate(vehicle.getVehicleCertificateData().getRegion());
	premium = premium * rates.getIsMajorKZCityCorrectionRate(vehicle.getVehicleCertificateData().getCity());
	premium = premium * rates.getVehicleTypeRate(vehicle.getVehicleClass());
	premium = premium * rates.getDriverExpirienceTypeRate(insured.getAgeClass(), insured.getExpirienceClass());
	premium = premium * rates.getVehicleAgeTypeRate(vehicle.getVehicleAgeClass());
	premium = premium * rates.getInsuranceClassTypeRate(insured.getInsuranceClassType());
	premium = premium * rates.getPolicyTermClassRate(policyTermClass);
	premium = premium * rates.getPrivilegeRate(insured.isHasAnyPrivilege());
	premium = Math.round(premium * 100) / 100; // округляем до "копеек"
	return premium;
    }
}
