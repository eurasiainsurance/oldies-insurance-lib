package com.lapsa.insurance.services.other;

import com.lapsa.insurance.domain.CalculationData;
import com.lapsa.insurance.domain.casco.Casco;

public interface CascoCalculationService {
    CalculationData calculateCasco(Casco casco) throws CalculationFailed;

    void calculateCascoCost(Casco casco) throws CalculationFailed;
}
