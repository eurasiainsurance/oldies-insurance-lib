package com.lapsa.insurance.test.messages;

import com.lapsa.insurance.elements.InsuredAgeAndExpirienceClass;

public class InsuredAgeAndExpirienceClassMessagesBundleTest
	extends EnumTypeMessagesBundleTest<InsuredAgeAndExpirienceClass> {

    @Override
    protected InsuredAgeAndExpirienceClass[] getAllEnumValues() {
	return InsuredAgeAndExpirienceClass.values();
    }

    @Override
    protected String getBundleBaseName() {
	return InsuredAgeAndExpirienceClass.BUNDLE_BASENAME;
    }
}
