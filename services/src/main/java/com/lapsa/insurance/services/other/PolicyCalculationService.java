package com.lapsa.insurance.services.other;

import com.lapsa.insurance.domain.policy.Policy;

public interface PolicyCalculationService {
    void calculatePolicyCost(Policy policy) throws CalculationFailed;
}
