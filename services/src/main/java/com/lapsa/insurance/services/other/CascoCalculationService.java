package com.lapsa.insurance.services.other;

import com.lapsa.insurance.domain.casco.Casco;

public interface CascoCalculationService {
    void calculateCascoCost(Casco casco) throws CalculationFailed;
}
