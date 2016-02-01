package kz.theeurasia.esbdproxy.service.ejbimpl.test;

import kz.theeurasia.esbdproxy.domain.dict.osgpovts.InsuranceClassTypeDict;

public final class TestConstants {
    public static final long INVALID_BRANCH_ID = 999999999l;
    public static final long INVALID_CANCELATION_REASON_ID = 999999999l;
    public static final long INVALID_CITY_ID = 999999999l;
    public static final long INVALID_COMPANY_ACTIVITY_KIND_ID = 999999999l;
    public static final long INVALID_COUNTRY_REGION_ID = 999999999l;
    public static final long INVALID_COUNTRY_ID = 999999999l;
    public static final long INVALID_ECONOMICS_SECTOR_ID = 999999999l;
    public static final long INVALID_IDENTITY_CARD_TYPE_ID = 999999999l;
    public static final long INVALID_INSURANCE_COMPANY_ID = 999999999l;
    public static final long INVALID_MARITAL_STATUS_ID = 999999999l;
    public static final long INVALID_SEX_ID = 999999999l;
    public static final long INVALID_USER_ID = 999999999l;
    public static final long INVALID_INSURANCE_AGE_EXPIRIENCE_ID = 999999999l;
    public static final long VALID_CLASS_TYPE_ID = 14l;
    public static final String INVALID_CLASS_TYPE_CODE = "QQ";
    public static final long INVALID_CLASS_TYPE_ID = 999999999l;
    public static final long INVALID_CLIENT_ID = 999999999l;
    public static final long VALID_CLIENT_ID = 14132412; // Evsyukovs ID
    public static final InsuranceClassTypeDict VALID_CLASS_TYPE_FOR_CLIENT = InsuranceClassTypeDict.CLASS_12; // Evsyukovs
													      // Class
    public static final long INVALID_VEHICLE_AGE_CLASS_ID = 999999999l;
    public static final long INVALID_VEHICLE_CLASS_ID = 999999999l;

    public static final Long VALID_VEHICLE_MANUFACTURER_ID = 45755l; // INFINTI
								     // FX35
    public static final String VALID_VEHICLE_MANUFACTURER_NAME = "INFINTI FX35";
    public static final Long ININVALID_VEHICLE_MANUFACTURER_ID = 999999999l;
    public static final String INVALID_VEHICLE_MANUFACTURER_NAME = "QQQ";

    public static final long VALID_VEHICLE_ID = 9187329l; // Vadims Car Infiniti
							  // FX 35
    public static final String VALID_VEHICLE_VIN_CODE = "JN1TANS51U0303376"; // Vadims
									     // Car
									     // Infiniti
									     // FX
									     // 35

    public static final String INVALID_VEHICLE_VIN_CODE = "QASDA";
    public static final long INVALID_VEHICLE_ID = 999999999l;

    public static final Long VALID_VEHICLE_MODEL_ID = 143827l;
    public static final String VALID_VEHICLE_MODEL_NAME = "INFINITI FX35";
    public static final Long ININVALID_VEHICLE_MODEL_ID = 999999999l;
}
