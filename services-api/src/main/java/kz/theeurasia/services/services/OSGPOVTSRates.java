package kz.theeurasia.services.services;

import kz.theeurasia.services.domain.global.CountryRegion;
import kz.theeurasia.services.domain.global.InsuranceClassType;
import kz.theeurasia.services.domain.osgpovts.DriverExpirienceClass;
import kz.theeurasia.services.domain.osgpovts.InsuredAgeClass;
import kz.theeurasia.services.domain.osgpovts.PolicyTermClass;
import kz.theeurasia.services.domain.osgpovts.VehicleAgeClass;
import kz.theeurasia.services.domain.osgpovts.VehicleClass;

public interface OSGPOVTSRates {

    double getBase();

    double getBaseRate();

    double getRegionRate(CountryRegion region);

    double getIsMajorCityCorrectionRate(boolean isMajorCity);

    double getVehicleTypeRate(VehicleClass vehicleType);

    double getDriverExpirienceTypeRate(InsuredAgeClass insuredAgeClass, DriverExpirienceClass insuredDriverExpirienceClass);

    double getVehicleAgeTypeRate(VehicleAgeClass vehicleAgeType);

    double getInsuranceClassTypeRate(InsuranceClassType insuranceClassType);

    double getPolicyTermClassRate(PolicyTermClass policyTermClass);

    double getPrivilegeRate(boolean hasPrivilege);
}
