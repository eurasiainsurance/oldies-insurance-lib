package com.lapsa.insurance.services.other;

import java.time.LocalDate;
import java.util.Calendar;

import com.lapsa.insurance.domain.CalculationData;
import com.lapsa.insurance.domain.policy.Policy;

public interface PolicyCalculationService {
    CalculationData calculate(Policy policy);

    CalculationData calculate(Policy policy, Calendar startDate, Calendar endDate);

    CalculationData calculate(Policy policy, Calendar startDate, int days);

    CalculationData calculate(Policy policy, LocalDate startDate, LocalDate endDate);

    CalculationData calculate(Policy policy, LocalDate startDate, int days);

    void calculatePolicyCost(Policy policy);

    void calculatePolicyCost(Policy policy, Calendar startDate, Calendar endDate);

    void calculatePolicyCost(Policy policy, Calendar startDate, int days);

    void calculatePolicyCost(Policy policy, LocalDate startDate, LocalDate endDate);

    void calculatePolicyCost(Policy policy, LocalDate startDate, int days);
}
