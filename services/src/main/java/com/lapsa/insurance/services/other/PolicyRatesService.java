package com.lapsa.insurance.services.other;

import com.lapsa.insurance.elements.InsuranceClassType;
import com.lapsa.insurance.elements.InsuredAgeClass;
import com.lapsa.insurance.elements.InsuredExpirienceClass;
import com.lapsa.insurance.elements.VehicleAgeClass;
import com.lapsa.insurance.elements.VehicleClass;
import com.lapsa.kz.country.KZArea;
import com.lapsa.kz.country.KZCity;

public interface PolicyRatesService {
    double getBase();

    double getBaseRate();

    double getRegionRate(KZArea region);

    double getIsMajorCityCorrectionRate(boolean isMajorCity);

    double getIsMajorKZCityCorrectionRate(KZCity city);

    double getVehicleTypeRate(VehicleClass vehicleType);

    double getDriverExpirienceTypeRate(InsuredAgeClass ageClass, InsuredExpirienceClass driverExpirienceClass);

    double getVehicleAgeTypeRate(VehicleAgeClass vehicleAgeType);

    double getInsuranceClassTypeRate(InsuranceClassType insuranceClassType);

    double getPrivilegeRate(boolean hasPrivilege);
}
