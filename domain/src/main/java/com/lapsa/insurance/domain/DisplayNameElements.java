package com.lapsa.insurance.domain;

import java.util.Locale;
import java.util.function.Function;

import com.lapsa.commons.elements.LocalizedElement;

public enum DisplayNameElements implements LocalizedElement {
    CONTACT_DATA,
    //
    COMPANY_CONTACT_PHONE,
    COMPANY_CONTACT_PHONE_UNDEFINED,
    //
    CALCULATION_DATA,
    CALCULATION_DATA_UNDEFINED,
    //
    POST_ADDRESS,
    //
    COMPANY_CONTACT_EMAIL,
    COMPANY_CONTACT_EMAIL_UNDEFINED,
    //
    INSURANCE_PERIOD_DATA,
    INSURANCE_PERIOD_DATA_FROM,
    INSURANCE_PERIOD_DATA_TILL,
    //
    COMPANY_POINT_OF_SALE,
    //
    GEO_POINT,
    GEO_POINT_LAT,
    GEO_POINT_LNG,
    //
    DRIVER_LICENSE_DATA,
    DRIVER_LICENSE_DATA_ISSUED,
    //
    IDENTITY_CARD_DATA,
    IDENTITY_CARD_DATA_ISSUED,
    //
    VEHICLE_CERTIFICATE_DATA,
    VEHICLE_CERTIFICATE_DATA_ISSUED,
    VEHICLE_CERTIFICATE_DATA_REGNUMBER,
    //
    REQUESTER_DATA,
    //
    OBTAINING_DATA,
    //
    PAYMENT_DATA,
    PAYMENT_REFERENCE,
    //
    PERSONAL_DATA,
    PERSONAL_DATA_DOB,
    PERSONAL_DATA_SEX,
    //
    POLICY_VEHICLE,
    POLICY_VEHICLE_CLASS,
    POLICY_VEHICLE_AGE_CLASS,
    //
    POLICY_DRIVER,
    //
    CASCO_VEHICLE,
    CASCO_VEHICLE_COST,
    CASCO_VEHICLE_AGE_CLASS,
    //
    CASCO_DRIVER,
    //
    USER,
    USER_LOGIN,
    //
    USER_LOGIN_LOGIN,
    //
    USER_GROUP,
    USER_GRPOUP_MEMBER,
    //
    INET_ADDR_DATA,
    INET_ADDR_DATA_HOST,
    //
    FIELD_ID_NUMBER,
    FIELD_EMAIL,
    FIELD_PHONE,
    FIELD_NUMBER,
    FIELD_STATUS,
    ;

    public Function<String, String> fieldAsCaptionMapper(final DisplayNameVariant variant,
	    final Locale locale) {
	return x -> displayName(variant, locale) + " '" + x + "'";
    }
}
