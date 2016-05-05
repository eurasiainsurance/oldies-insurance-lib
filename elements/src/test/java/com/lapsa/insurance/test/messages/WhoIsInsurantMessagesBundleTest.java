package com.lapsa.insurance.test.messages;

import com.lapsa.insurance.elements.WhoIsInsurant;

public class WhoIsInsurantMessagesBundleTest extends EnumTypeMessagesBundleTest<WhoIsInsurant> {

    @Override
    protected WhoIsInsurant[] getAllEnumValues() {
	return WhoIsInsurant.values();
    }

    @Override
    protected String getBundleBaseName() {
	return WhoIsInsurant.BUNDLE_BASENAME;
    }
}
