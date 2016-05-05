package com.lapsa.insurance.test.messages;

import com.lapsa.insurance.elements.InsuredAgeClass;

public class InsuredAgeClassMessagesBundleTest extends EnumTypeMessagesBundleTest<InsuredAgeClass>{

    @Override
    protected InsuredAgeClass[] getAllEnumValues() {
	return InsuredAgeClass.values();
    }

    @Override
    protected String getBundleBaseName() {
	return InsuredAgeClass.BUNDLE_BASENAME;
    }
}
