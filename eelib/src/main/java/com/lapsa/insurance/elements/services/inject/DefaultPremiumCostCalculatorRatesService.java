package com.lapsa.insurance.elements.services.inject;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;

import com.lapsa.insurance.elements.InsuranceClassType;
import com.lapsa.insurance.elements.InsuredAgeClass;
import com.lapsa.insurance.elements.InsuredExpirienceClass;
import com.lapsa.insurance.elements.PolicyTermClass;
import com.lapsa.insurance.elements.VehicleAgeClass;
import com.lapsa.insurance.elements.VehicleClass;
import com.lapsa.insurance.elements.services.PremiumCostCalculatorRatesService;
import com.lapsa.kz.country.KZArea;
import com.lapsa.kz.country.KZCity;
import com.lapsa.kz.country.KZCityType;

@Singleton
public class DefaultPremiumCostCalculatorRatesService implements PremiumCostCalculatorRatesService {

    private final double MRP = 2121;
    private final double BASE_RATE = 1.9;

    private final Map<KZArea, Double> REGION_RATES = new HashMap<>();
    private final double MAJOR_CITY_CORRECTION_RATE = 1d;
    private final double NON_MAJOR_CITY_CORRECTION_RATE = 0.8d;
    private final Map<VehicleClass, Double> VEHICLE_TYPE_RATES = new HashMap<>();
    private final Map<InsuredAgeClass, Map<InsuredExpirienceClass, Double>> DRIVER_EXPIRIENCE_CLASS_RATES = new HashMap<InsuredAgeClass, Map<InsuredExpirienceClass, Double>>();
    private final Map<VehicleAgeClass, Double> VEHICLE_AGE_RATES = new HashMap<>();
    private final Map<InsuranceClassType, Double> INSURANCE_CLASS_TYPES_RATES = new HashMap<>();
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

	VEHICLE_TYPE_RATES.put(VehicleClass.BUS16, 3.26d);
	VEHICLE_TYPE_RATES.put(VehicleClass.BUSOVR16, 3.45d);
	VEHICLE_TYPE_RATES.put(VehicleClass.CARGO, 3.98d);
	VEHICLE_TYPE_RATES.put(VehicleClass.CAR, 2.09d);
	VEHICLE_TYPE_RATES.put(VehicleClass.MOTO, 1d);
	VEHICLE_TYPE_RATES.put(VehicleClass.TRAILER, 1d);
	VEHICLE_TYPE_RATES.put(VehicleClass.TRAM, 2.33d);

	DRIVER_EXPIRIENCE_CLASS_RATES.put(InsuredAgeClass.OVER25,
		new HashMap<InsuredExpirienceClass, Double>());
	DRIVER_EXPIRIENCE_CLASS_RATES.get(InsuredAgeClass.OVER25).put(InsuredExpirienceClass.MORE2, 1d);
	DRIVER_EXPIRIENCE_CLASS_RATES.get(InsuredAgeClass.OVER25).put(InsuredExpirienceClass.LESS2, 1.05d);
	DRIVER_EXPIRIENCE_CLASS_RATES.put(InsuredAgeClass.UNDER25,
		new HashMap<InsuredExpirienceClass, Double>());
	DRIVER_EXPIRIENCE_CLASS_RATES.get(InsuredAgeClass.UNDER25).put(InsuredExpirienceClass.MORE2, 1.05d);
	DRIVER_EXPIRIENCE_CLASS_RATES.get(InsuredAgeClass.UNDER25).put(InsuredExpirienceClass.LESS2, 1.1d);

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
	if (city.equals(KZCity.OTHER))
	    return NON_MAJOR_CITY_CORRECTION_RATE;
	if (city.getType() == null)
	    return 0;
	return (city.getType().equals(KZCityType.MAJOR) || city.getType().equals(KZCityType.REGIONAL_CENTER)
		|| city.getType().equals(KZCityType.REGIONAL_SUBORDINATION) ? MAJOR_CITY_CORRECTION_RATE
			: NON_MAJOR_CITY_CORRECTION_RATE);
    }

    @Override
    public double getVehicleTypeRate(VehicleClass vehicleType) {
	if (!VEHICLE_TYPE_RATES.containsKey(vehicleType))
	    return 0;
	return VEHICLE_TYPE_RATES.get(vehicleType);
    }

    @Override
    public double getDriverExpirienceTypeRate(InsuredAgeClass ageClass,
	    InsuredExpirienceClass driverExpirienceClass) {
	if (!DRIVER_EXPIRIENCE_CLASS_RATES.containsKey(ageClass))
	    return 0;
	if (!DRIVER_EXPIRIENCE_CLASS_RATES.get(ageClass).containsKey(driverExpirienceClass))
	    return 0;
	return DRIVER_EXPIRIENCE_CLASS_RATES.get(ageClass).get(driverExpirienceClass);
    }

    @Override
    public double getVehicleAgeTypeRate(VehicleAgeClass vehicleAgeType) {
	if (!VEHICLE_AGE_RATES.containsKey(vehicleAgeType))
	    return 0;
	return VEHICLE_AGE_RATES.get(vehicleAgeType);
    }

    @Override
    public double getInsuranceClassTypeRate(InsuranceClassType insuranceClassType) {
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
