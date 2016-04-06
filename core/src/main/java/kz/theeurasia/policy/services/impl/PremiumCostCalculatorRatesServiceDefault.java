package kz.theeurasia.policy.services.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Default;
import javax.inject.Singleton;

import com.lapsa.kz.country.KZArea;
import com.lapsa.kz.country.KZCity;
import com.lapsa.kz.country.KZCityType;

import kz.theeurasia.esbdproxy.domain.dict.osgpovts.InsuranceClassTypeDict;
import kz.theeurasia.esbdproxy.domain.dict.osgpovts.VehicleAgeClassDict;
import kz.theeurasia.esbdproxy.domain.dict.osgpovts.VehicleClassDict;
import kz.theeurasia.esbdproxy.domain.enums.osgpovts.InsuredAgeClassEnum;
import kz.theeurasia.esbdproxy.domain.enums.osgpovts.InsuredExpirienceClassEnum;
import kz.theeurasia.policy.domain.PolicyTermClass;
import kz.theeurasia.policy.services.PremiumCostCalculatorRatesService;

@Default
@Singleton
public class PremiumCostCalculatorRatesServiceDefault implements PremiumCostCalculatorRatesService {

    private final double MRP = 2121;
    private final double BASE_RATE = 1.9;

    private final Map<KZArea, Double> REGION_RATES = new HashMap<>();
    private final double MAJOR_CITY_CORRECTION_RATE = 1d;
    private final double NON_MAJOR_CITY_CORRECTION_RATE = 0.8d;
    private final Map<VehicleClassDict, Double> VEHICLE_TYPE_RATES = new HashMap<>();
    private final Map<InsuredAgeClassEnum, Map<InsuredExpirienceClassEnum, Double>> DRIVER_EXPIRIENCE_CLASS_RATES = new HashMap<InsuredAgeClassEnum, Map<InsuredExpirienceClassEnum, Double>>();
    private final Map<VehicleAgeClassDict, Double> VEHICLE_AGE_RATES = new HashMap<>();
    private final Map<InsuranceClassTypeDict, Double> INSURANCE_CLASS_TYPES_RATES = new HashMap<>();
    private final Map<PolicyTermClass, Double> POLICY_TERM_RATES = new HashMap<>();
    private final double HAS_PRIVILEGE_RATE = 0.5d;
    private final double HAS_NO_PRIVILEGE_RATE = 1d;

    @PostConstruct
    protected void initConstants() {
	REGION_RATES.put(KZArea.GAST, 2.2d); // 01
	REGION_RATES.put(KZArea.GALM, 2.96d); // 02
	REGION_RATES.put(KZArea.OAKM, 1.32d); // 03
	REGION_RATES.put(KZArea.OAKT, 1.35d); // 04
	REGION_RATES.put(KZArea.OALM, 1.78d); // 05
	REGION_RATES.put(KZArea.OATY, 2.69d); // 06
	REGION_RATES.put(KZArea.OZK, 1.17d); // 07
	REGION_RATES.put(KZArea.OZHM, 1d); // 08
	REGION_RATES.put(KZArea.OKGD, 1.39d); // 09
	REGION_RATES.put(KZArea.OKST, 1.95d); // 10
	REGION_RATES.put(KZArea.OKZL, 1.09d); // 11
	REGION_RATES.put(KZArea.OMNG, 1.15d); // 12
	REGION_RATES.put(KZArea.OUK, 1.01d); // 13
	REGION_RATES.put(KZArea.OPVL, 1.63d); // 14
	REGION_RATES.put(KZArea.OSK, 1.33d); // 15
	REGION_RATES.put(KZArea.OVK, 1.96d); // 16

	VEHICLE_TYPE_RATES.put(VehicleClassDict.BUS16, 3.26d);
	VEHICLE_TYPE_RATES.put(VehicleClassDict.BUSOVR16, 3.45d);
	VEHICLE_TYPE_RATES.put(VehicleClassDict.CARGO, 3.98d);
	VEHICLE_TYPE_RATES.put(VehicleClassDict.CAR, 2.09d);
	VEHICLE_TYPE_RATES.put(VehicleClassDict.MOTO, 1d);
	VEHICLE_TYPE_RATES.put(VehicleClassDict.TRAILER, 1d);
	VEHICLE_TYPE_RATES.put(VehicleClassDict.TRAM, 2.33d);

	DRIVER_EXPIRIENCE_CLASS_RATES.put(InsuredAgeClassEnum.OVER25,
		new HashMap<InsuredExpirienceClassEnum, Double>());
	DRIVER_EXPIRIENCE_CLASS_RATES.get(InsuredAgeClassEnum.OVER25).put(InsuredExpirienceClassEnum.MORE2, 1d);
	DRIVER_EXPIRIENCE_CLASS_RATES.get(InsuredAgeClassEnum.OVER25).put(InsuredExpirienceClassEnum.LESS2, 1.05d);
	DRIVER_EXPIRIENCE_CLASS_RATES.put(InsuredAgeClassEnum.UNDER25,
		new HashMap<InsuredExpirienceClassEnum, Double>());
	DRIVER_EXPIRIENCE_CLASS_RATES.get(InsuredAgeClassEnum.UNDER25).put(InsuredExpirienceClassEnum.MORE2, 1.05d);
	DRIVER_EXPIRIENCE_CLASS_RATES.get(InsuredAgeClassEnum.UNDER25).put(InsuredExpirienceClassEnum.LESS2, 1.1d);

	VEHICLE_AGE_RATES.put(VehicleAgeClassDict.UNDER7, 1d);
	VEHICLE_AGE_RATES.put(VehicleAgeClassDict.OVER7, 1.1d);

	INSURANCE_CLASS_TYPES_RATES.put(InsuranceClassTypeDict.CLASS_0, 2.3d);
	INSURANCE_CLASS_TYPES_RATES.put(InsuranceClassTypeDict.CLASS_1, 1.55d);
	INSURANCE_CLASS_TYPES_RATES.put(InsuranceClassTypeDict.CLASS_2, 1.4d);
	INSURANCE_CLASS_TYPES_RATES.put(InsuranceClassTypeDict.CLASS_3, 1d);
	INSURANCE_CLASS_TYPES_RATES.put(InsuranceClassTypeDict.CLASS_4, 0.95d);
	INSURANCE_CLASS_TYPES_RATES.put(InsuranceClassTypeDict.CLASS_5, 0.9d);
	INSURANCE_CLASS_TYPES_RATES.put(InsuranceClassTypeDict.CLASS_6, 0.85d);
	INSURANCE_CLASS_TYPES_RATES.put(InsuranceClassTypeDict.CLASS_7, 0.8d);
	INSURANCE_CLASS_TYPES_RATES.put(InsuranceClassTypeDict.CLASS_8, 0.75d);
	INSURANCE_CLASS_TYPES_RATES.put(InsuranceClassTypeDict.CLASS_9, 0.7d);
	INSURANCE_CLASS_TYPES_RATES.put(InsuranceClassTypeDict.CLASS_10, 0.65d);
	INSURANCE_CLASS_TYPES_RATES.put(InsuranceClassTypeDict.CLASS_11, 0.6d);
	INSURANCE_CLASS_TYPES_RATES.put(InsuranceClassTypeDict.CLASS_12, 0.55d);
	INSURANCE_CLASS_TYPES_RATES.put(InsuranceClassTypeDict.CLASS_13, 0.5d);
	INSURANCE_CLASS_TYPES_RATES.put(InsuranceClassTypeDict.CLASS_M, 2.45d);

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
    public double getRegionRate(KZArea region) {
	if (!REGION_RATES.containsKey(region))
	    return 0;
	return REGION_RATES.get(region);
    }

    @Override
    public double getIsMajorCityCorrectionRate(boolean isMajorCity) {
	return (isMajorCity ? MAJOR_CITY_CORRECTION_RATE : NON_MAJOR_CITY_CORRECTION_RATE);
    }

    @Override
    public double getIsMajorKZCityCorrectionRate(KZCity city) {
	if (city == null)
	    return 0;
	return (city.getType().equals(KZCityType.MAJOR) || city.getType().equals(KZCityType.REGION_CENTER)
		? MAJOR_CITY_CORRECTION_RATE : NON_MAJOR_CITY_CORRECTION_RATE);
    }

    @Override
    public double getVehicleTypeRate(VehicleClassDict vehicleType) {
	if (!VEHICLE_TYPE_RATES.containsKey(vehicleType))
	    return 0;
	return VEHICLE_TYPE_RATES.get(vehicleType);
    }

    @Override
    public double getDriverExpirienceTypeRate(InsuredAgeClassEnum ageClass,
	    InsuredExpirienceClassEnum driverExpirienceClass) {
	if (!DRIVER_EXPIRIENCE_CLASS_RATES.containsKey(ageClass))
	    return 0;
	if (!DRIVER_EXPIRIENCE_CLASS_RATES.get(ageClass).containsKey(driverExpirienceClass))
	    return 0;
	return DRIVER_EXPIRIENCE_CLASS_RATES.get(ageClass).get(driverExpirienceClass);
    }

    @Override
    public double getVehicleAgeTypeRate(VehicleAgeClassDict vehicleAgeType) {
	if (!VEHICLE_AGE_RATES.containsKey(vehicleAgeType))
	    return 0;
	return VEHICLE_AGE_RATES.get(vehicleAgeType);
    }

    @Override
    public double getInsuranceClassTypeRate(InsuranceClassTypeDict insuranceClassType) {
	if (!INSURANCE_CLASS_TYPES_RATES.containsKey(insuranceClassType))
	    return 0;
	return INSURANCE_CLASS_TYPES_RATES.get(insuranceClassType);
    }

    @Override
    public double getPolicyTermClassRate(PolicyTermClass policyTermClass) {
	if (!POLICY_TERM_RATES.containsKey(policyTermClass))
	    return 0;
	return POLICY_TERM_RATES.get(policyTermClass);
    }

    @Override
    public double getPrivilegeRate(boolean hasPrivilege) {
	return (hasPrivilege ? HAS_PRIVILEGE_RATE : HAS_NO_PRIVILEGE_RATE);
    }
}
