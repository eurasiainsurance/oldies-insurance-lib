package kz.theeurasia.services.services.impl;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import kz.theeurasia.services.domain.global.CountryRegion;
import kz.theeurasia.services.domain.global.InsuranceClassType;
import kz.theeurasia.services.domain.osgpovts.DriverExpirienceClass;
import kz.theeurasia.services.domain.osgpovts.InsuredAgeClass;
import kz.theeurasia.services.domain.osgpovts.PolicyTermClass;
import kz.theeurasia.services.domain.osgpovts.VehicleAgeClass;
import kz.theeurasia.services.domain.osgpovts.VehicleClass;
import kz.theeurasia.services.services.OSGPOVTSRates;

@Singleton
public class OSGPOVTSRatesImplementation implements OSGPOVTSRates {
    private final double MRP = 2121;
    private final double BASE_RATE = 1.9;

    private final Map<CountryRegion, Double> REGION_RATES = new HashMap<>();
    private final double MAJOR_CITY_CORRECTION_RATE = 1d;
    private final double NON_MAJOR_CITY_CORRECTION_RATE = 0.8d;
    private final Map<VehicleClass, Double> VEHICLE_TYPE_RATES = new HashMap<>();
    private final Map<InsuredAgeClass, Map<DriverExpirienceClass, Double>> DRIVER_EXPIRIENCE_CLASS_RATES = new HashMap<InsuredAgeClass, Map<DriverExpirienceClass, Double>>();
    private final Map<VehicleAgeClass, Double> VEHICLE_AGE_RATES = new HashMap<>();
    private final Map<InsuranceClassType, Double> INSURANCE_CLASS_TYPES_RATES = new HashMap<>();
    private final Map<PolicyTermClass, Double> POLICY_TERM_RATES = new HashMap<>();
    private final double HAS_PRIVILEGE_RATE = 0.5d;
    private final double HAS_NO_PRIVILEGE_RATE = 1d;

    private Logger logger = Logger.getAnonymousLogger();

    @PostConstruct
    protected void initConstants() {
	REGION_RATES.put(CountryRegion.GAST, 2.2d); // 01
	REGION_RATES.put(CountryRegion.GALM, 2.96d); // 02
	REGION_RATES.put(CountryRegion.OAKM, 1.32d); // 03
	REGION_RATES.put(CountryRegion.OAKT, 1.35d); // 04
	REGION_RATES.put(CountryRegion.OALM, 1.78d); // 05
	REGION_RATES.put(CountryRegion.OATY, 2.69d); // 06
	REGION_RATES.put(CountryRegion.OZK, 1.17d); // 07
	REGION_RATES.put(CountryRegion.OZHM, 1d); // 08
	REGION_RATES.put(CountryRegion.OKGD, 1.39d); // 09
	REGION_RATES.put(CountryRegion.OKST, 1.95d); // 10
	REGION_RATES.put(CountryRegion.OKZL, 1.09d); // 11
	REGION_RATES.put(CountryRegion.OMNG, 1.15d); // 12
	REGION_RATES.put(CountryRegion.OUK, 1.01d); // 13
	REGION_RATES.put(CountryRegion.OPVL, 1.63d); // 14
	REGION_RATES.put(CountryRegion.OSK, 1.33d); // 15
	REGION_RATES.put(CountryRegion.OVK, 1.96d); // 16

	VEHICLE_TYPE_RATES.put(VehicleClass.BUS16, 3.26d);
	VEHICLE_TYPE_RATES.put(VehicleClass.BUSOVR16, 3.45d);
	VEHICLE_TYPE_RATES.put(VehicleClass.CARGO, 3.98d);
	VEHICLE_TYPE_RATES.put(VehicleClass.CAR, 2.09d);
	VEHICLE_TYPE_RATES.put(VehicleClass.MOTO, 1d);
	VEHICLE_TYPE_RATES.put(VehicleClass.TRAILER, 1d);
	VEHICLE_TYPE_RATES.put(VehicleClass.TRAM, 2.33d);

	DRIVER_EXPIRIENCE_CLASS_RATES.put(InsuredAgeClass.OVER25, new HashMap<DriverExpirienceClass, Double>());
	DRIVER_EXPIRIENCE_CLASS_RATES.get(InsuredAgeClass.OVER25).put(DriverExpirienceClass.MORE2, 1d);
	DRIVER_EXPIRIENCE_CLASS_RATES.get(InsuredAgeClass.OVER25).put(DriverExpirienceClass.LESS2, 1.05d);
	DRIVER_EXPIRIENCE_CLASS_RATES.put(InsuredAgeClass.UNDER25, new HashMap<DriverExpirienceClass, Double>());
	DRIVER_EXPIRIENCE_CLASS_RATES.get(InsuredAgeClass.UNDER25).put(DriverExpirienceClass.MORE2, 1.05d);
	DRIVER_EXPIRIENCE_CLASS_RATES.get(InsuredAgeClass.UNDER25).put(DriverExpirienceClass.LESS2, 1.1d);

	VEHICLE_AGE_RATES.put(VehicleAgeClass.UNDER7, 1d);
	VEHICLE_AGE_RATES.put(VehicleAgeClass.OVER7, 1.1d);

	INSURANCE_CLASS_TYPES_RATES.put(InsuranceClassType.CLASS_0, 2.3d);
	INSURANCE_CLASS_TYPES_RATES.put(InsuranceClassType.CLASS_1, 1.55d);
	INSURANCE_CLASS_TYPES_RATES.put(InsuranceClassType.CLASS_2, 1.4d);
	INSURANCE_CLASS_TYPES_RATES.put(InsuranceClassType.CLASS_3, 1d);
	INSURANCE_CLASS_TYPES_RATES.put(InsuranceClassType.CLASS_4, 0.95d);
	INSURANCE_CLASS_TYPES_RATES.put(InsuranceClassType.CLASS_5, 0.9d);
	INSURANCE_CLASS_TYPES_RATES.put(InsuranceClassType.CLASS_6, 0.85d);
	INSURANCE_CLASS_TYPES_RATES.put(InsuranceClassType.CLASS_7, 0.8d);
	INSURANCE_CLASS_TYPES_RATES.put(InsuranceClassType.CLASS_8, 0.75d);
	INSURANCE_CLASS_TYPES_RATES.put(InsuranceClassType.CLASS_9, 0.7d);
	INSURANCE_CLASS_TYPES_RATES.put(InsuranceClassType.CLASS_10, 0.65d);
	INSURANCE_CLASS_TYPES_RATES.put(InsuranceClassType.CLASS_11, 0.6d);
	INSURANCE_CLASS_TYPES_RATES.put(InsuranceClassType.CLASS_12, 0.55d);
	INSURANCE_CLASS_TYPES_RATES.put(InsuranceClassType.CLASS_13, 0.5d);
	INSURANCE_CLASS_TYPES_RATES.put(InsuranceClassType.CLASS_M, 2.45d);

	POLICY_TERM_RATES.put(PolicyTermClass.YEAR, 1d);
	POLICY_TERM_RATES.put(PolicyTermClass.DAY5, 0.1d);
	POLICY_TERM_RATES.put(PolicyTermClass.MONTH1_2, 0.3d);
	POLICY_TERM_RATES.put(PolicyTermClass.MONTH10_11, 0.95d);
	POLICY_TERM_RATES.put(PolicyTermClass.DAY16_MONTH, 0.2d);
	POLICY_TERM_RATES.put(PolicyTermClass.MONTH2_3, 0.4d);
	POLICY_TERM_RATES.put(PolicyTermClass.MONTH3_4, 0.5d);
	POLICY_TERM_RATES.put(PolicyTermClass.MONTH4_5, 0.6d);
	POLICY_TERM_RATES.put(PolicyTermClass.MONTH5_6, 0.7d);
	POLICY_TERM_RATES.put(PolicyTermClass.DAY6_15, 0.15d);
	POLICY_TERM_RATES.put(PolicyTermClass.MONTH6_7, 0.75d);
	POLICY_TERM_RATES.put(PolicyTermClass.MONTH7_8, 0.8d);
	POLICY_TERM_RATES.put(PolicyTermClass.MONTH8_9, 0.85d);
	POLICY_TERM_RATES.put(PolicyTermClass.MONTH9_10, 0.9d);
	POLICY_TERM_RATES.put(PolicyTermClass.OVER11MONTH, 1d);
    }

    @Override
    public double getBase() {
	return MRP;
    }

    @Override
    public double getBaseRate() {
	return BASE_RATE;
    }

    @Override
    public double getRegionRate(CountryRegion region) {
	if (!REGION_RATES.containsKey(region))
	    throw new InvalidParameterException();
	return REGION_RATES.get(region);
    }

    @Override
    public double getIsMajorCityCorrectionRate(boolean isMajorCity) {
	return (isMajorCity ? MAJOR_CITY_CORRECTION_RATE : NON_MAJOR_CITY_CORRECTION_RATE);
    }

    @Override
    public double getVehicleTypeRate(VehicleClass vehicleType) {
	if (!VEHICLE_TYPE_RATES.containsKey(vehicleType))
	    throw new InvalidParameterException();
	return VEHICLE_TYPE_RATES.get(vehicleType);
    }

    @Override
    public double getDriverExpirienceTypeRate(InsuredAgeClass ageClass,
	    DriverExpirienceClass driverExpirienceClass) {
	if (!DRIVER_EXPIRIENCE_CLASS_RATES.containsKey(ageClass))
	    throw new InvalidParameterException("Can't calculate ratio. Invalid parameter " + ageClass);
	if (!DRIVER_EXPIRIENCE_CLASS_RATES.get(ageClass).containsKey(driverExpirienceClass))
	    throw new InvalidParameterException("Can't calculate ratio. Invalid parameter " + driverExpirienceClass);
	return DRIVER_EXPIRIENCE_CLASS_RATES.get(ageClass).get(driverExpirienceClass);
    }

    @Override
    public double getVehicleAgeTypeRate(VehicleAgeClass vehicleAgeType) {
	if (!VEHICLE_AGE_RATES.containsKey(vehicleAgeType))
	    throw new InvalidParameterException();
	return VEHICLE_AGE_RATES.get(vehicleAgeType);
    }

    @Override
    public double getInsuranceClassTypeRate(InsuranceClassType insuranceClassType) {
	if (!INSURANCE_CLASS_TYPES_RATES.containsKey(insuranceClassType))
	    throw new InvalidParameterException();
	return INSURANCE_CLASS_TYPES_RATES.get(insuranceClassType);
    }

    @Override
    public double getPolicyTermClassRate(PolicyTermClass policyTermClass) {
	if (!POLICY_TERM_RATES.containsKey(policyTermClass))
	    throw new InvalidParameterException();
	return POLICY_TERM_RATES.get(policyTermClass);
    }

    @Override
    public double getPrivilegeRate(boolean hasPrivilege) {
	return (hasPrivilege ? HAS_PRIVILEGE_RATE : HAS_NO_PRIVILEGE_RATE);
    }
}
