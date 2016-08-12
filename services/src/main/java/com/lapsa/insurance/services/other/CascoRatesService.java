package com.lapsa.insurance.services.other;

import com.lapsa.insurance.elements.CascoCarAgeClass;
import com.lapsa.insurance.elements.CascoDeductibleFullRate;
import com.lapsa.insurance.elements.CascoDeductiblePartialRate;

public interface CascoRatesService {

    double getBaseRate(boolean deductible, CascoDeductiblePartialRate deductibleValue) throws CalculationFailed;

    double getIncrRateDeductibleFull(CascoDeductibleFullRate deductibleFullDeathRate) throws CalculationFailed;

    double getIncrRateSpecialServiceStation(boolean specialServiceStationRequired,
	    CascoCarAgeClass carAgeClass) throws CalculationFailed;

    double getIncrRateNoPoliceCallRequired(boolean noPoliceCallRequired)
	    throws CalculationFailed;

    double getIncrRateNoGuiltNoDeductibleRequired(boolean noGuiltNoDeductibleRequired) throws CalculationFailed;

    double getIncrRateHelpWithPoliceRequired(boolean helpWithPoliceRequired)
	    throws CalculationFailed;

    double getIncrRateEvacuatorRequired(boolean evacuatorRequired)
	    throws CalculationFailed;

    double getIncrRateReplacementCarRequired(boolean replacementCarRequired)
	    throws CalculationFailed;

    double getDiscountCoverage(boolean coverRoadAccidents, boolean coverNonRoadAccidents) throws CalculationFailed;

    double getDiscountContractEndsAfterFirstCase(boolean contractEndsAfterFirstCase) throws CalculationFailed;

    double getAmountThirdPartyLiabilityCoverage(boolean thirdPartyLiabilityCoverage) throws CalculationFailed;

    double getAmountDriverAndPassengerCoverage(boolean driverAndPassengerCoverage, int driverAndPassengerCount) throws CalculationFailed;


}
