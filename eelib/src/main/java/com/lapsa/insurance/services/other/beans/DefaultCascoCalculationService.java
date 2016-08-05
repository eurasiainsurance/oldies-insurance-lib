package com.lapsa.insurance.services.other.beans;

import static com.lapsa.insurance.services.other.beans.Calcs.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;

import javax.enterprise.context.ApplicationScoped;

import com.lapsa.fin.FinCurrency;
import com.lapsa.insurance.domain.casco.Casco;
import com.lapsa.insurance.services.other.CalculationFailed;
import com.lapsa.insurance.services.other.CascoCalculationService;
import com.lapsa.insurance.services.other.CascoRatesService;

@ApplicationScoped
public class DefaultCascoCalculationService implements CascoCalculationService {

    private CascoRatesService cascoRates = new DefaultCascoRatesService();

    @Override
    public void calculateCascoCost(Casco casco) throws CalculationFailed {
	double annualCost = cascoCostAnnual(casco);
	casco.getCalculation().setPremiumCost(roundMoney(annualCost));
	casco.getCalculation().setPremiumCurrency(FinCurrency.KZT);
    }

    @Override
    public void calculateCascoCost(Casco casco, LocalDate start, LocalDate end) throws CalculationFailed {
	double annualCost = cascoCostAnnual(casco);
	double cost = costAnnualToPeriod(annualCost, start, end);
	casco.getCalculation().setPremiumCost(roundMoney(cost));
	casco.getCalculation().setPremiumCurrency(FinCurrency.KZT);
    }

    @Override
    public void calculateCascoCost(Casco casco, Calendar startDate, Calendar endDate) throws CalculationFailed {
	LocalDate start = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	LocalDate end = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	calculateCascoCost(casco, start, end);
    }

    @Override
    public void calculateCascoCost(Casco casco, Calendar startDate, int days) throws CalculationFailed {
	LocalDate start = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	calculateCascoCost(casco, start, days);
    }

    @Override
    public void calculateCascoCost(Casco casco, LocalDate start, int days) throws CalculationFailed {
	double annualCost = cascoCostAnnual(casco);
	double cost = costAnnualToPeriod(annualCost, start, days);
	casco.getCalculation().setPremiumCost(roundMoney(cost));
	casco.getCalculation().setPremiumCurrency(FinCurrency.KZT);
    }

    // PRIVATE

    private double cascoCostAnnual(Casco casco) throws CalculationFailed {

	// insurance rate
	double base = cascoRates.getBaseRate(casco.getDeductiblePartialDamageRate());
	double rate = base;
	rate += base * cascoRates.getIncrRateSpecialServiceStation(casco.isSpecialServiceStationRequired(),
		casco.getInsuredVehicle().getCarAgeClass());

	rate += base * cascoRates.getIncrRateNoPoliceCallRequired(casco.isNoPoliceCallRequired());
	rate += base * cascoRates.getIncrRateNoGuiltNoDeductibleRequired(casco.isNoGuiltNoDeductibleRequired());
	rate += base * cascoRates.getIncrRateDeductibleFullDeath(casco.getDeductibleFullDeathRate());
	rate += base * cascoRates.getIncrRateHelpWithPoliceRequired(casco.isHelpWithPoliceRequired());
	rate += base * cascoRates.getIncrRateEvacuatorRequired(casco.isEvacuatorRequired());
	rate += base * cascoRates.getIncrRateReplacementCarRequired(casco.isReplacementCarRequired());

	double annualCost = casco.getInsuredVehicle().getCost() * rate;

	// discount
	double discount = 0;
	discount += cascoRates.getDiscountCoverage(casco.isCoverRoadAccidents(),
		casco.isCoverNonRoadAccidents());
	discount += cascoRates.getDiscountContractEndsAfterFirstCase(casco.isContractEndsAfterFirstCase());

	annualCost = annualCost * (1 - discount);

	// complex insurance
	annualCost += cascoRates.getAmountThirdPartyLiabilityCoverage(casco.isThirdPartyLiabilityCoverage());
	annualCost += cascoRates.getAmountDriverAndPassengerCoverage(casco.isDriverAndPassengerCoverage(),
		casco.getDriverAndPassengerCount());

	return annualCost;
    }
}
