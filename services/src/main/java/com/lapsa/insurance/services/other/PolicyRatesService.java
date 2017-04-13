package com.lapsa.insurance.services.other;

import com.lapsa.insurance.elements.InsuranceClassType;
import com.lapsa.insurance.elements.InsuredAgeClass;
import com.lapsa.insurance.elements.InsuredExpirienceClass;
import com.lapsa.insurance.elements.PolicyTemporaryEntryTimeCategory;
import com.lapsa.insurance.elements.VehicleAgeClass;
import com.lapsa.insurance.elements.VehicleClass;
import com.lapsa.kz.country.KZArea;
import com.lapsa.kz.country.KZCity;

public interface PolicyRatesService {
    double getBase() throws CalculationFailed;

    double getBaseRate() throws CalculationFailed;

    double getPolicyTemporaryEntryTimeCategoryRate(PolicyTemporaryEntryTimeCategory timeCategory)
	    throws CalculationFailed;

    double getRegionRate(KZArea region) throws CalculationFailed;

    double getIsMajorCityCorrectionRate(boolean isMajorCity) throws CalculationFailed;

    double getIsMajorCityCorrectionRate(KZCity city) throws CalculationFailed;

    double getTotalAreaRate(KZArea area, KZCity city, boolean temporaryEntry, boolean forcedMajorCity)
	    throws CalculationFailed;

    double getVehicleTypeRate(VehicleClass vehicleType) throws CalculationFailed;

    double getDriverExpirienceTypeRate(InsuredAgeClass ageClass, InsuredExpirienceClass driverExpirienceClass)
	    throws CalculationFailed;

    double getVehicleAgeTypeRate(VehicleAgeClass vehicleAgeType) throws CalculationFailed;

    double getInsuranceClassTypeRate(InsuranceClassType insuranceClassType, boolean temporaryEntry)
	    throws CalculationFailed;

    double getPrivilegeRate(boolean hasPrivilege) throws CalculationFailed;
}
