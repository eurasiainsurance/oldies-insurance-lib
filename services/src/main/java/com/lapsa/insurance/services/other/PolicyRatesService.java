package com.lapsa.insurance.services.other;

import com.lapsa.insurance.elements.InsuranceClassType;
import com.lapsa.insurance.elements.InsuredAgeClass;
import com.lapsa.insurance.elements.InsuredExpirienceClass;
import com.lapsa.insurance.elements.PolicyTemporaryEntryTimeCategory;
import com.lapsa.insurance.elements.VehicleAgeClass;
import com.lapsa.insurance.elements.VehicleClass;
import com.lapsa.kz.country.KZArea;

public interface PolicyRatesService {
    double getBase() throws CalculationFailed;

    double getBaseRate() throws CalculationFailed;

    double getTemporaryEntryRate();

    double getPolicyTemporaryEntryTimeCategoryRate(PolicyTemporaryEntryTimeCategory timeCategory)
	    throws CalculationFailed;

    double getRegionRate(KZArea region) throws CalculationFailed;

    double getNonMajorCityCorrectionRate() throws CalculationFailed;

    double getVehicleTypeRate(VehicleClass vehicleType) throws CalculationFailed;

    double getDriverExpirienceTypeRate(InsuredAgeClass ageClass, InsuredExpirienceClass driverExpirienceClass)
	    throws CalculationFailed;

    double getVehicleAgeTypeRate(VehicleAgeClass vehicleAgeType) throws CalculationFailed;

    double getInsuranceClassTypeRate(InsuranceClassType insuranceClassType)
	    throws CalculationFailed;

    double getPrivilegerRate() throws CalculationFailed;

}
