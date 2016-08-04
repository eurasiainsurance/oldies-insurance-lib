package com.lapsa.insurance.services.other.beans;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.lapsa.fin.FinCurrency;
import com.lapsa.insurance.domain.casco.Casco;
import com.lapsa.insurance.domain.policy.Policy;
import com.lapsa.insurance.domain.policy.PolicyDriver;
import com.lapsa.insurance.domain.policy.PolicyVehicle;
import com.lapsa.insurance.services.other.CalculationService;
import com.lapsa.insurance.services.other.CascoRatesService;
import com.lapsa.insurance.services.other.PremiumCostCalculatorRatesService;

@ApplicationScoped
public class DefaultCalculationService implements CalculationService {

    @Inject
    private PremiumCostCalculatorRatesService policyRates;

    @Inject
    private CascoRatesService cascoRates;

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

    @Override
    public void calculateCascoCost(Casco casco) {
	double annualCost = cascoCostAnnual(casco);
	casco.getCalculation().setPremiumCost(roundMoney(annualCost));
	casco.getCalculation().setPremiumCurrency(FinCurrency.KZT);
    }

    @Override
    public void calculateCascoCost(Casco casco, LocalDate start, LocalDate end) {
	double annualCost = cascoCostAnnual(casco);
	double cost = costAnnualToPeriod(annualCost, start, end);
	casco.getCalculation().setPremiumCost(roundMoney(cost));
	casco.getCalculation().setPremiumCurrency(FinCurrency.KZT);
    }

    @Override
    public void calculateCascoCost(Casco casco, Calendar startDate, Calendar endDate) {
	LocalDate start = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	LocalDate end = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	calculateCascoCost(casco, start, end);
    }

    @Override
    public void calculateCascoCost(Casco casco, Calendar startDate, int days) {
	LocalDate start = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	calculateCascoCost(casco, start, days);
    }

    @Override
    public void calculateCascoCost(Casco casco, LocalDate start, int days) {
	double annualCost = cascoCostAnnual(casco);
	double cost = costAnnualToPeriod(annualCost, start, days);
	casco.getCalculation().setPremiumCost(roundMoney(cost));
	casco.getCalculation().setPremiumCurrency(FinCurrency.KZT);
    }

    // PRIVATE

    private static double costAnnualToPeriod(double annualCost, LocalDate start, LocalDate end) {
	if (start.isAfter(end))
	    throw new RuntimeException("Start date is after the end date");
	double cost = 0;
	LocalDate c = start;
	while (c.isBefore(end) || c.isEqual(end)) {
	    cost += annualCost / (start.getChronology().isLeapYear(start.getYear()) ? 366 : 365);
	    c = c.plusDays(1);
	}
	return cost;
    }

    private static double costAnnualToPeriod(double annualCost, LocalDate start, int days) {
	LocalDate end = start.plusDays(days);
	return costAnnualToPeriod(annualCost, start, end);
    }

    private double cascoCostAnnual(Casco casco) {
	double rate = 0;
	rate += cascoRates.getRateDeductible(casco.getDeductiblePartialDamageRate());
	rate += cascoRates.getRateDeductibleFullDeath(casco.getDeductibleFullDeathRate());
	rate += cascoRates.getRateSpecialServiceStation(casco.isSpecialServiceStationRequired(),
		casco.getInsuredVehicle().getCarAgeClass());
	rate += cascoRates.getRateNoPoliceRequired(casco.isNoPoliceRequired());
	rate += cascoRates.getRateNoDeductibleAppliedIfNotGuilty(casco.isNoDeductibleAppliedIfNotGuilty());
	rate += cascoRates.getRateContactToPolicyRequired(casco.isContactToPoliceRequired());
	rate += cascoRates.getRateEvacuatorRequired(casco.isEvacuatorRequired());
	rate += cascoRates.getRateReplacementCarRequired(casco.isReplacementCarRequired());

	double discount = 0;
	discount += cascoRates.getDiscountCoverage(casco.isCoverRoadAccidents(), casco.isCoverNonRoadAccidents());
	discount += cascoRates.getDiscountContractEndsAfterFirstCase(casco.isContractEndsAfterFirstCase());

	double annualCost = casco.getInsuredVehicle().getCost() * rate * (1 - discount);

	if (casco.isThirdPartyLiabilityCoverage())
	    annualCost += cascoRates.getAmountThirdPartyLiabilityCoverage();

	if (casco.isDriverAndPassengerCoverage())
	    annualCost += cascoRates.getAmountDriverAndPassengerCoverage(casco.getDriverAndPassengerCount());

	return annualCost;
    }

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

    private static double roundMoney(final double input) {
	double output = input;
	output *= 100d;
	output = Math.round(output);
	output /= 100d;
	return output;
    }
}
