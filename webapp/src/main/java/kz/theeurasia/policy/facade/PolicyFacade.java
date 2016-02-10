package kz.theeurasia.policy.facade;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import kz.theeurasia.policy.domain.InsuredDriverData;
import kz.theeurasia.policy.domain.InsuredVehicleData;
import kz.theeurasia.policy.domain.PolicyRequestData;
import kz.theeurasia.policy.domain.PolicyTermClass;
import kz.theeurasia.policy.services.PremiumCostCalculatorRatesService;

@ManagedBean
@ViewScoped
public class PolicyFacade {

    @ManagedProperty("#{premiumCostCalculatorRatesService}")
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
	premium = premium * rates.getRegionRate(vehicle.getCertificateData().getRegion());
	premium = premium * rates.getIsMajorCityCorrectionRate(vehicle.getCertificateData().isMajorCity());
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
