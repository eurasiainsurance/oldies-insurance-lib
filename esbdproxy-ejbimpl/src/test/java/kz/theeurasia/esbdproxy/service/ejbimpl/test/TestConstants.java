package kz.theeurasia.esbdproxy.service.ejbimpl.test;

import kz.theeurasia.esbdproxy.domain.dict.osgpovts.InsuranceClassTypeDict;
import kz.theeurasia.esbdproxy.domain.entities.general.SubjectCompanyEntity;
import kz.theeurasia.esbdproxy.domain.entities.general.SubjectPersonEntity;
import kz.theeurasia.esbdproxy.domain.enums.general.SubjectTypeEnum;

public final class TestConstants {
    // Branch
    public static final long INVALID_BRANCH_ID = 999999999L;

    // CancelationReason
    public static final long INVALID_CANCELATION_REASON_ID = 999999999L;

    // City
    public static final long INVALID_CITY_ID = 999999999L;

    // CompanyActivityKind
    public static final long INVALID_COMPANY_ACTIVITY_KIND_ID = 999999999L;

    // CountryRegion
    public static final long INVALID_COUNTRY_REGION_ID = 999999999L;

    // Country
    public static final long INVALID_COUNTRY_ID = 999999999L;

    // EconomicsSector
    public static final long INVALID_ECONOMICS_SECTOR_ID = 999999999L;

    // IndentityCardType
    public static final long INVALID_IDENTITY_CARD_TYPE_ID = 999999999L;

    // InsuranceCompany
    public static final long INVALID_INSURANCE_COMPANY_ID = 999999999L;

    // MaritalStatus
    public static final long INVALID_MARITAL_STATUS_ID = 999999999L;

    // Sex
    public static final long INVALID_SEX_ID = 999999999L;

    // User
    public static final long INVALID_USER_ID = 999999999L;

    // InsuranceAgeExpirience
    public static final long INVALID_INSURANCE_AGE_EXPIRIENCE_ID = 999999999L;

    // InsuranceClassType
    public static final long VALID_INSURANCE_CLASS_TYPE_ID = 14L;
    public static final long INVALID_INSURANCE_CLASS_TYPE_ID = 999999999L;
    public static final String INVALID_INSURANCE_CLASS_TYPE_CODE = "QQ";

    // Subject
    public static final long INVALID_SUBJECT_PERSON_ID = 999999999L;
    public static final long VALID_SUBJECT_PERSON_ID = 14132412; // Evsyukovs ID
    public static final InsuranceClassTypeDict VALID_CLASS_TYPE_FOR_CLIENT = InsuranceClassTypeDict.CLASS_12; // Evsyukovs
													      // Class
    public static final long INVALID_VEHICLE_AGE_CLASS_ID = 999999999L;
    public static final long INVALID_VEHICLE_CLASS_ID = 999999999L;

    // VehicleManufacturer
    public static final long VALID_VEHICLE_MANUFACTURER_ID = 45755L; // INFINTI
								     // FX35
    public static final String VALID_VEHICLE_MANUFACTURER_NAME = "INFINTI FX35";
    public static final long ININVALID_VEHICLE_MANUFACTURER_ID = 999999999L;
    public static final String INVALID_VEHICLE_MANUFACTURER_NAME = "QQQ";

    // VehicleModel
    public static final long VALID_VEHICLE_MODEL_ID = 143827L;
    public static final String VALID_VEHICLE_MODEL_NAME = "INFINITI FX35";
    public static final long ININVALID_VEHICLE_MODEL_ID = 999999999L;

    // Vehicle
    public static final long VALID_VEHICLE_ID = 9187329L; // Vadims Car Infiniti
							  // FX 35
    public static final String VALID_VEHICLE_VIN_CODE = "JN1TANS51U0303376"; // Vadims
									     // Car
									     // Infiniti
									     // FX
									     // 35
    public static final String INVALID_VEHICLE_VIN_CODE = "NOVIN";
    public static final long INVALID_VEHICLE_ID = 999999999L;

    // Subject
    public static final long[] VALID_SUBJECT_IDS = new long[] { 1, 100 };
    public static final String[] VALID_SUBJECT_ID_NUMBERS = new String[] {
	    "930840000071",
	    "581114350286" };
    public static final SubjectTypeEnum[] VALID_SUBJECT_TYPES = new SubjectTypeEnum[] {
	    SubjectTypeEnum.COMPANY,
	    SubjectTypeEnum.PERSON };
    public static final Class<?>[] VALID_SUBJECT_CLASSES = new Class<?>[] {
	    SubjectCompanyEntity.class,
	    SubjectPersonEntity.class };

    public static final long INVALID_SUBJECT_ID = -1L;
    public static final String INVALID_SUBJECT_ID_NUMBER = "6666";

    // SubjectCompany
    public static final long[] VALID_SUBJECT_COMPANY_IDS = new long[] { 1, 2 };
    public static final long[] INVALID_SUBJECT_COMPANY_IDS = new long[] { 100, -1 };
    public static final String[] VALID_SUBJECT_COMPANY_BINS = new String[] { "930840000071" };
    public static final String[] INVALID_SUBJECT_COMPANY_BINS = new String[] { "581114350286", "ZZZZ" };

    // SubjectPerson
    public static final long[] VALID_SUBJECT_PERSON_IDS = new long[] { 100, 14132412 };
    public static final long[] INVALID_SUBJECT_PERSON_IDS = new long[] { 1, 2, -1 };
    public static final String[] VALID_SUBJECT_PERSON_IINS = new String[] { "581114350286", "870622300359" };
    public static final String[] INVALID_SUBJECT_PERSON_IINS = new String[] { "930840000071", "ZZZZ" };

    // Policy
    public static final Long VALID_POLICY_ID = 31571176L;
    public static final Long INVALID_POLICY_ID = 1L;
    public static final String VALID_POLICY_NUMBER = "0088851";
    public static final String INVALID_POLICY_NUMBER = "ZZZ";

    // KZCity
    public static final Long INVALID_KZ_CITY_ID = 666L;

}
