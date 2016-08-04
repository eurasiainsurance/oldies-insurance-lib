package com.lapsa.insurance.services.other;

import com.lapsa.insurance.elements.CascoCarAgeClass;
import com.lapsa.insurance.elements.CascoDeductibleFullDeathRate;
import com.lapsa.insurance.elements.CascoDeductiblePartialDamageRate;

public interface CascoRatesService {

    double getRateDeductible(CascoDeductiblePartialDamageRate deductiblePartialDamageRate);

    double getRateDeductibleFullDeath(CascoDeductibleFullDeathRate deductibleFullDeathRate);

    double getRateSpecialServiceStation(boolean specialServiceStationRequired, CascoCarAgeClass carAgeClass);

    double getRateNoPoliceRequired(boolean noPoliceRequired);

    double getRateNoDeductibleAppliedIfNotGuilty(boolean noDeductibleAppliedIfNotGuilty);

    double getRateContactToPolicyRequired(boolean contactToPoliceRequired);

    double getRateEvacuatorRequired(boolean evacuatorRequired);

    double getRateReplacementCarRequired(boolean replacementCarRequired);

    double getDiscountCoverage(boolean coverRoadAccidents, boolean coverNonRoadAccidents);

    double getDiscountContractEndsAfterFirstCase(boolean contractEndsAfterFirstCase);

    double getAmountThirdPartyLiabilityCoverage();

    double getAmountDriverAndPassengerCoverage(int driverAndPassengerCount);

}
