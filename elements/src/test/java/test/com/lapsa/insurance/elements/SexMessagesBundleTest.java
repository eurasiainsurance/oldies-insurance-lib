package test.com.lapsa.insurance.elements;

import com.lapsa.insurance.elements.Sex;

import test.com.lapsa.insurance.EnumTypeMessagesBundleTest;

public class SexMessagesBundleTest extends EnumTypeMessagesBundleTest<Sex> {

    @Override
    protected Sex[] getAllEnumValues() {
	return Sex.values();
    }

    @Override
    protected String getBundleBaseName() {
	return Sex.BUNDLE_BASENAME;
    }
}
