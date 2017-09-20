package com.lapsa.insurance.elements;

import com.lapsa.commons.elements.LocalizedElement;

public interface InsuranceLocalizedElement extends LocalizedElement {

    public static final String BUNDDLE_BASE_NAME = "ElementsLocalization";

    default String getBundleBaseName() {
	return BUNDDLE_BASE_NAME;
    }

}
