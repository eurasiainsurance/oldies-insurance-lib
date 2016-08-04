package com.lapsa.insurance.services.other;

import java.time.LocalDate;
import java.util.Calendar;

import com.lapsa.insurance.domain.casco.Casco;
import com.lapsa.insurance.domain.policy.Policy;

public interface CalculationService {
    void calculatePolicyCost(Policy policy);

    void calculatePolicyCost(Policy policy, Calendar startDate, Calendar endDate);

    void calculatePolicyCost(Policy policy, Calendar startDate, int days);

    void calculatePolicyCost(Policy policy, LocalDate startDate, LocalDate endDate);

    void calculatePolicyCost(Policy policy, LocalDate startDate, int days);

    void calculateCascoCost(Casco casco);

    void calculateCascoCost(Casco casco, Calendar startDate, Calendar endDate);

    void calculateCascoCost(Casco casco, Calendar startDate, int days);

    void calculateCascoCost(Casco casco, LocalDate startDate, LocalDate endDate);

    void calculateCascoCost(Casco casco, LocalDate startDate, int days);

}
