package kz.theeurasia.policy.services;

import java.util.List;

import com.lapsa.insurance.domain.InsuredDriverData;
import com.lapsa.insurance.domain.InsuredVehicleData;
import com.lapsa.insurance.elements.PolicyTermClass;

public interface CalculationService {
    double calculatePremiumCost(List<InsuredDriverData> drivers, List<InsuredVehicleData> vehicles,
	    PolicyTermClass termClass);
}
