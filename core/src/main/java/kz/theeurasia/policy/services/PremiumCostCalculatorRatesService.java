package kz.theeurasia.policy.services;

import com.lapsa.kz.country.KZArea;
import com.lapsa.kz.country.KZCity;

import kz.theeurasia.esbdproxy.domain.dict.osgpovts.InsuranceClassTypeDict;
import kz.theeurasia.esbdproxy.domain.dict.osgpovts.VehicleAgeClassDict;
import kz.theeurasia.esbdproxy.domain.dict.osgpovts.VehicleClassDict;
import kz.theeurasia.esbdproxy.domain.enums.osgpovts.InsuredAgeClassEnum;
import kz.theeurasia.esbdproxy.domain.enums.osgpovts.InsuredExpirienceClassEnum;
import kz.theeurasia.policy.domain.PolicyTermClass;

public interface PremiumCostCalculatorRatesService {
    double getBase();

    double getBaseRate();

    double getRegionRate(KZArea region);

    double getIsMajorCityCorrectionRate(boolean isMajorCity);

    double getIsMajorKZCityCorrectionRate(KZCity city);

    double getVehicleTypeRate(VehicleClassDict vehicleType);

    double getDriverExpirienceTypeRate(InsuredAgeClassEnum ageClass, InsuredExpirienceClassEnum driverExpirienceClass);

    double getVehicleAgeTypeRate(VehicleAgeClassDict vehicleAgeType);

    double getInsuranceClassTypeRate(InsuranceClassTypeDict insuranceClassType);

    double getPolicyTermClassRate(PolicyTermClass policyTermClass);

    double getPrivilegeRate(boolean hasPrivilege);
}
