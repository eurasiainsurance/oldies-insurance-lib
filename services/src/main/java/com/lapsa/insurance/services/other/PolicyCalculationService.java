package com.lapsa.insurance.services.other;

import com.lapsa.insurance.domain.CalculationData;
import com.lapsa.insurance.domain.policy.Policy;

public interface PolicyCalculationService {
    CalculationData calculate(Policy policy);

    void calculatePolicyCost(Policy policy);
}
