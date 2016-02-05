package kz.theeurasia.policy.osgpovts.facade;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import kz.theeurasia.policy.osgpovts.domain.InsuredDriver;
import kz.theeurasia.policy.osgpovts.domain.InsuredVehicle;
import kz.theeurasia.policy.osgpovts.domain.PolicyRequest;
import kz.theeurasia.policy.osgpovts.domain.PolicyTermClass;
import kz.theeurasia.policy.osgpovts.services.PremiumCostCalculatorRatesService;

@ManagedBean
@ViewScoped
public class PolicyFacade {

    @ManagedProperty("#{premiumCostCalculatorRatesService}")
    private PremiumCostCalculatorRatesService rates;

    public PolicyRequest initNew() {
	PolicyRequest policy = new PolicyRequest();
	return policy;
    }

    public void calculatePremiumCost(PolicyRequest policy) {
	double maximumCost = 0d;
	for (InsuredDriver driver : policy.getInsuredDrivers())
	    for (InsuredVehicle vehicle : policy.getInsuredVehicles()) {
		double cost = _calculatePremiumCostVariant(driver, vehicle, policy.getTermClass());
		if (maximumCost < cost)
		    maximumCost = cost;
	    }
	policy.setCalculatedPremiumCost(maximumCost);
    }

    private double _calculatePremiumCostVariant(InsuredDriver insured, InsuredVehicle vehicle,
	    PolicyTermClass policyTermClass) {
	double premium = rates.getBase();
	premium = premium * rates.getBaseRate();
	premium = premium * rates.getRegionRate(vehicle.getRegion());
	premium = premium * rates.getIsMajorCityCorrectionRate(vehicle.isMajorCity());
	premium = premium * rates.getVehicleTypeRate(vehicle.getVehicleClass());
	premium = premium
		* rates.getDriverExpirienceTypeRate(insured.getAgeClass(),
			insured.getExpirienceClass());
	premium = premium * rates.getVehicleAgeTypeRate(vehicle.getVehicleAgeClass());
	premium = premium * rates.getInsuranceClassTypeRate(insured.getInsuranceClassType());
	premium = premium * rates.getPolicyTermClassRate(policyTermClass);
	premium = premium * rates.getPrivilegeRate(insured.isHasAnyPrivilege());
	premium = Math.round(premium * 100) / 100; // округляем до "копеек"
	return premium;
    }

    // GENERATED

    public void setRates(PremiumCostCalculatorRatesService rates) {
	this.rates = rates;
    }
}