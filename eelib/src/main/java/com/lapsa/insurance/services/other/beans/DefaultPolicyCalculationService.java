package com.lapsa.insurance.services.other.beans;

import static com.lapsa.insurance.services.other.beans.Calcs.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.lapsa.fin.FinCurrency;
import com.lapsa.insurance.domain.policy.Policy;
import com.lapsa.insurance.domain.policy.PolicyDriver;
import com.lapsa.insurance.domain.policy.PolicyVehicle;
import com.lapsa.insurance.services.other.PolicyCalculationService;
import com.lapsa.insurance.services.other.PolicyRatesService;

@ApplicationScoped
public class DefaultPolicyCalculationService implements PolicyCalculationService {

    @Inject
    private PolicyRatesService policyRates;

    @Override
    public void calculatePolicyCost(Policy policy) {
	double annualCost = policyCostAnnual(policy.getInsuredDrivers(),
		policy.getInsuredVehicles());
	policy.getCalculation().setPremiumCost(roundMoney(annualCost));
	policy.getCalculation().setPremiumCurrency(FinCurrency.KZT);
    }

    @Override
    public void calculatePolicyCost(Policy policy, LocalDate start, LocalDate end) {
	double annualCost = policyCostAnnual(policy.getInsuredDrivers(), policy.getInsuredVehicles());
	double cost = costAnnualToPeriod(annualCost, start, end);
	policy.getCalculation().setPremiumCost(roundMoney(cost));
	policy.getCalculation().setPremiumCurrency(FinCurrency.KZT);
    }

    @Override
    public void calculatePolicyCost(Policy policy, LocalDate start, int days) {
	double annualCost = policyCostAnnual(policy.getInsuredDrivers(), policy.getInsuredVehicles());
	double cost = costAnnualToPeriod(annualCost, start, days);
	policy.getCalculation().setPremiumCost(roundMoney(cost));
	policy.getCalculation().setPremiumCurrency(FinCurrency.KZT);
    }

    @Override
    public void calculatePolicyCost(Policy policy, Calendar startDate, Calendar endDate) {
	LocalDate start = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	LocalDate end = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	calculatePolicyCost(policy, start, end);
    }

    @Override
    public void calculatePolicyCost(Policy policy, Calendar startDate, int days) {
	LocalDate start = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	calculatePolicyCost(policy, start, days);
    }

    // PRIVATE

    private double policyCostAnnual(List<PolicyDriver> drivers, List<PolicyVehicle> vehicles) {
	double maximumCost = 0d;
	for (PolicyDriver driver : drivers)
	    for (PolicyVehicle vehicle : vehicles) {
		double cost = policyCostAnnualVariant(driver, vehicle);
		if (cost == 0) {
		    return 0;
		}
		if (maximumCost < cost)
		    maximumCost = cost;
	    }
	return maximumCost;
    }

    private double policyCostAnnualVariant(PolicyDriver insured, PolicyVehicle vehicle) {
	double premium = policyRates.getBase();
	premium *= policyRates.getBaseRate();
	premium *= policyRates.getRegionRate(vehicle.getRegion());
	premium *= policyRates.getIsMajorKZCityCorrectionRate(vehicle.getCity());
	premium *= policyRates.getVehicleTypeRate(vehicle.getVehicleClass());
	premium *= policyRates.getDriverExpirienceTypeRate(insured.getAgeClass(), insured.getExpirienceClass());
	premium *= policyRates.getVehicleAgeTypeRate(vehicle.getVehicleAgeClass());
	premium *= policyRates.getInsuranceClassTypeRate(insured.getInsuranceClassType());
	premium *= policyRates.getPrivilegeRate(insured.isHasAnyPrivilege());
	return premium;
    }
}
