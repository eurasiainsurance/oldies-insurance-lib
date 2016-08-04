package com.lapsa.insurance.services.other;

import java.util.List;

import com.lapsa.insurance.domain.policy.PolicyDriver;
import com.lapsa.insurance.domain.policy.PolicyVehicle;

public interface CalculationService {
    double calculatePremiumCost(List<PolicyDriver> drivers, List<PolicyVehicle> vehicles);
}
