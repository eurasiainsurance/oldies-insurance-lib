package com.lapsa.insurance.services.other.beans;

import static com.lapsa.insurance.elements.CascoDeductiblePartialDamageRate.*;
import static com.lapsa.insurance.services.other.beans.Maps.*;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Stream;

import javax.inject.Singleton;

import com.lapsa.insurance.elements.CascoCarAgeClass;
import com.lapsa.insurance.elements.CascoDeductibleFullDeathRate;
import com.lapsa.insurance.elements.CascoDeductiblePartialDamageRate;
import com.lapsa.insurance.services.other.CalculationFailed;
import com.lapsa.insurance.services.other.CascoRatesService;

@Singleton
public class DefaultCascoRatesService implements CascoRatesService {

    private static final double DISCOUNT_CONTRACT_ENDS_AFTER_FIRST_CASE = 0.25d; // 25%
    private static final double DISCOUNT_COVER_ROAD_ACCIDENTS_ONLY = 0.25d; // 25%
    private static final double DISCOUNT_COVER_NON_ROAD_ACCIDENTS_ONLY = 0.50d; // 50%
    private static final double DICOUNT_COVER_ALL_ACCIDENTS = 0.00d; // no
								     // discount

    private static final double AMOUNT_THIRD_PARTY_LIABILITY_COVER = 8000d;
    private static final double AMOUNT_DRIVER_COVERATE = 2000d;

    private static final Map<CascoDeductiblePartialDamageRate, Double> BASE_RATES = Collections
	    .unmodifiableMap(Stream.of(
		    entry(ZERO, 0.0351d), // 3.51%
		    entry(PERCENT0_5, 0.0260d), // 2.60%
		    entry(PERCENT1, 0.0240d), // 2,40%
		    entry(PERCENT2, 0.0220d), // 2,20%
		    entry(PERCENT3, 0.0200d), // 2,00%
		    entry(PERCENT5, 0.0180d), // 1,80%
		    entry(PERCENT10, 0.0160d)) // 1,60%
		    .collect(entriesToMap()));

    private static final double RATES_DEDUCTIBLE_FULL_TO_5_PERCENT = 0.10d; // 10%
    private static final double RATES_SPECIAL_STATINONS_UPTO3 = 0.10d;// 10%
    private static final double RATES_SPECIAL_STATINONS_3TO7 = 0.20d; // 20%

    private static final double RATES_NO_POLICE_CALL_REQUIRED = 0.15d;// 15%

    private static final double RATES_NO_GUILT_NO_DEDUCTIBLE_REQUIRED = 0.20d;// 20%
    private static final double RATES_HELP_WITH_POLICY_REQUIRED = 0.10d;// 10%
    private static final double RATES_EVACUATOR_REQUIRED = 0.05d; // 5%
    private static final double RATES_REPLACEMENT_CAR_REQUIRED = 0.35d; // 35%

    @Override
    public double getBaseRate(CascoDeductiblePartialDamageRate deductible) throws CalculationFailed {
	if (!BASE_RATES.containsKey(deductible))
	    throw new CalculationFailed(String.format("No rate for '%1$s'", deductible));
	return BASE_RATES.get(deductible);

    }

    @Override
    public double getIncrRateDeductibleFullDeath(CascoDeductibleFullDeathRate deductibleFullDeathRate)
	    throws CalculationFailed {
	switch (deductibleFullDeathRate) {
	case PERCENT5:
	    return RATES_DEDUCTIBLE_FULL_TO_5_PERCENT;
	case PERCENT10:
	    return 0;
	default:
	    throw new CalculationFailed(String.format("No rate for '%1$s'", deductibleFullDeathRate));
	}
    }

    @Override
    public double getIncrRateSpecialServiceStation(boolean specialServiceStationRequired,
	    CascoCarAgeClass carAgeClass) throws CalculationFailed {
	if (!specialServiceStationRequired)
	    return 0;
	switch (carAgeClass) {
	case UNDER3:
	    return RATES_SPECIAL_STATINONS_UPTO3;
	case FROM3TO7:
	    return RATES_SPECIAL_STATINONS_3TO7;
	default:
	    throw new CalculationFailed(String.format("No rate for '%1$s'", carAgeClass));
	}
    }

    @Override
    public double getIncrRateNoPoliceCallRequired(boolean noPoliceRequired) throws CalculationFailed {
	if (!noPoliceRequired)
	    return 0;
	return RATES_NO_POLICE_CALL_REQUIRED;
    }

    @Override
    public double getIncrRateNoGuiltNoDeductibleRequired(
	    boolean noGuiltNoDeductibleRequired) throws CalculationFailed {
	if (!noGuiltNoDeductibleRequired)
	    return 0;
	return RATES_NO_GUILT_NO_DEDUCTIBLE_REQUIRED;
    }

    @Override
    public double getIncrRateHelpWithPoliceRequired(boolean helpWithPoliceRequired) throws CalculationFailed {
	if (!helpWithPoliceRequired)
	    return 0;
	return RATES_HELP_WITH_POLICY_REQUIRED;
    }

    @Override
    public double getIncrRateEvacuatorRequired(boolean evacuatorRequired) throws CalculationFailed {
	if (!evacuatorRequired)
	    return 0;
	return RATES_EVACUATOR_REQUIRED;
    }

    @Override
    public double getIncrRateReplacementCarRequired(boolean replacementCarRequired) throws CalculationFailed {
	if (!replacementCarRequired)
	    return 0;
	return RATES_REPLACEMENT_CAR_REQUIRED;
    }

    @Override
    public double getDiscountCoverage(boolean coverRoadAccidents,
	    boolean coverNonRoadAccidents) throws CalculationFailed {
	if (coverRoadAccidents && !coverNonRoadAccidents)
	    return DISCOUNT_COVER_ROAD_ACCIDENTS_ONLY;
	if (!coverRoadAccidents && coverNonRoadAccidents)
	    return DISCOUNT_COVER_NON_ROAD_ACCIDENTS_ONLY;
	if (coverRoadAccidents && coverNonRoadAccidents)
	    return DICOUNT_COVER_ALL_ACCIDENTS;
	throw new CalculationFailed(
		"Casco cost calculation failed. At least one of the coverage types required: Road Accidents non-Road Accidents");
    }

    @Override
    public double getDiscountContractEndsAfterFirstCase(
	    boolean contractEndsAfterFirstCase) throws CalculationFailed {
	if (!contractEndsAfterFirstCase)
	    return 0;
	return DISCOUNT_CONTRACT_ENDS_AFTER_FIRST_CASE;
    }

    @Override
    public double getAmountThirdPartyLiabilityCoverage(boolean thirdPartyLiabilityCoverage) throws CalculationFailed {
	if (!thirdPartyLiabilityCoverage)
	    return 0;
	return AMOUNT_THIRD_PARTY_LIABILITY_COVER;
    }

    @Override
    public double getAmountDriverAndPassengerCoverage(boolean driverAndPassengerCoverage, int driverAndPassengerCount)
	    throws CalculationFailed {
	if (!driverAndPassengerCoverage)
	    return 0;
	if (driverAndPassengerCount < 1)
	    throw new CalculationFailed("Invalid count of insured drivers/passengers");
	return AMOUNT_DRIVER_COVERATE * driverAndPassengerCount;
    }
}
