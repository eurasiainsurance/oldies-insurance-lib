package com.lapsa.insurance.domain;

import com.lapsa.commons.elements.LocalizedElement;

public enum DisplayNameElements implements LocalizedElement {
    CONTACT_DATA, CONTACT_DATA_EMPTY, //
    COMPANY_CONTACT_PHONE, COMPANY_CONTACT_PHONE_EMPTY,
    ;

    public static final String BUNDLE_BASENAME = "DomainLocalization";

    @Override
    public String getBundleBaseName() {
	return BUNDLE_BASENAME;
    }

}
