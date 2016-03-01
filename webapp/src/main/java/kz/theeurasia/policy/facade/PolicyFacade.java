package kz.theeurasia.policy.facade;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import kz.theeurasia.policy.domain.InsuredDriverData;
import kz.theeurasia.policy.domain.InsuredVehicleData;
import kz.theeurasia.policy.domain.PolicyRequestData;
import kz.theeurasia.policy.domain.PolicyTermClass;
import kz.theeurasia.policy.services.PremiumCostCalculatorRatesService;

@Named
@ViewScoped
public class PolicyFacade {

    @Inject
    private PremiumCostCalculatorRatesService rates;

    public PolicyRequestData initNew() {
	PolicyRequestData policy = new PolicyRequestData();
	return policy;
    }

    public void calculatePremiumCost(PolicyRequestData policy) {
	double maximumCost = 0d;
	for (InsuredDriverData driver : policy.getInsuredDrivers())
	    for (InsuredVehicleData vehicle : policy.getInsuredVehicles()) {
		double cost = _calculatePremiumCostVariant(driver, vehicle, policy.getTermClass());
		if (maximumCost < cost)
		    maximumCost = cost;
	    }
	policy.setCalculatedPremiumCost(maximumCost);
    }

    private double _calculatePremiumCostVariant(InsuredDriverData insured, InsuredVehicleData vehicle,
	    PolicyTermClass policyTermClass) {
	double premium = rates.getBase();
	premium = premium * rates.getBaseRate();
	premium = premium * rates.getRegionRate(vehicle.getVehicleCertificateData().getRegion());
	premium = premium * rates.getIsMajorCityCorrectionRate(vehicle.getVehicleCertificateData().isMajorCity());
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
