package com.lapsa.insurance.services.other.beans;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.lapsa.insurance.domain.policy.PolicyDriver;
import com.lapsa.insurance.domain.policy.PolicyVehicle;
import com.lapsa.insurance.services.other.CalculationService;
import com.lapsa.insurance.services.other.PremiumCostCalculatorRatesService;

@ApplicationScoped
public class DefaultCalculationService implements CalculationService {

    @Inject
    private PremiumCostCalculatorRatesService rates;

    @Override
    public double calculatePremiumCost(List<PolicyDriver> drivers, List<PolicyVehicle> vehicles) {
	double maximumCost = 0d;
	for (PolicyDriver driver : drivers)
	    for (PolicyVehicle vehicle : vehicles) {
		double cost = _calculatePremiumCostVariant(driver, vehicle);
		if (cost == 0) {
		    return 0;
		}
		if (maximumCost < cost)
		    maximumCost = cost;
	    }
	return maximumCost;
    }

    private double _calculatePremiumCostVariant(PolicyDriver insured, PolicyVehicle vehicle) {
	double premium = rates.getBase();
	premium *= rates.getBaseRate();
	premium *= rates.getRegionRate(vehicle.getRegion());
	premium *= rates.getIsMajorKZCityCorrectionRate(vehicle.getCity());
	premium *= rates.getVehicleTypeRate(vehicle.getVehicleClass());
	premium *= rates.getDriverExpirienceTypeRate(insured.getAgeClass(), insured.getExpirienceClass());
	premium *= rates.getVehicleAgeTypeRate(vehicle.getVehicleAgeClass());
	premium *= rates.getInsuranceClassTypeRate(insured.getInsuranceClassType());
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
