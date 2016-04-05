package kz.theeurasia.policy.services;

public enum Messages {

    LABEL_INSURED_AGE_CLASS_PREFIX("label.si.insured-age-class."),
    LABEL_INSURED_EXPIRIENCE_CLASS_PREFIX("label.si.insured-expirience-class."),
    LABEL_VEHICLE_AGE_CLASS_PREFIX("label.si.vehicle-age-class."),
    LABEL_VEHICLE_CLASS_PREFIX("label.si.vehicle-class."),
    LABEL_SI_SEX_PREFIX("label.si.sex."),
    LABEL_SI_COUNTRY_REGION_PREFIX("label.si.country-region."),
    LABEL_SI_IDENTITY_CARD_TYPE_PREFIX("label.si.identity-card-type."),
    LABEL_SI_WHO_IS_INSURANT_PREFIX("label.si.who-is-insurant."),
    LABEL_SI_SCAN_COPIES_TRANSFER_METHOD_PREFIX("label.si.scan-copies-transfer-method."),
    LABEL_SI_UNSPECIFIED("label.si.UNSPECIFIED");

    public static final String BUNDLE_BASE_NAME = "Messages";

    private final String code;

    Messages(String code) {
	this.code = code;
    }

    public String getCode() {
	return code;
    }
}
