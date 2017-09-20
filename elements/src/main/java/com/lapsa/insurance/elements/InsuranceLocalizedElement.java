package com.lapsa.insurance.elements;

import com.lapsa.commons.elements.LocalizedElement;

public interface InsuranceLocalizedElement extends LocalizedElement {

    public static final String BUNDLE_BASENAME = "ElementsLocalization";

    @Override
    default String getBundleBaseName() {
	return BUNDLE_BASENAME;
    }
}
