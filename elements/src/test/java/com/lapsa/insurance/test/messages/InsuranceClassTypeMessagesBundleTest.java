package com.lapsa.insurance.test.messages;

import com.lapsa.insurance.elements.InsuranceClassType;

public class InsuranceClassTypeMessagesBundleTest extends EnumTypeMessagesBundleTest<InsuranceClassType>{

    @Override
    protected InsuranceClassType[] getAllEnumValues() {
	return InsuranceClassType.values();
    }

    @Override
    protected String getBundleBaseName() {
	return InsuranceClassType.BUNDLE_BASENAME;
    }
}
