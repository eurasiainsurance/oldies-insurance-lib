package com.lapsa.insurance.test.messages;

import com.lapsa.insurance.elements.MaritalStatus;

public class MaritalStatusMessagesBundleTest extends EnumTypeMessagesBundleTest<MaritalStatus>{

    @Override
    protected MaritalStatus[] getAllEnumValues() {
	return MaritalStatus.values();
    }

    @Override
    protected String getBundleBaseName() {
	return MaritalStatus.BUNDLE_BASENAME;
    }
}
