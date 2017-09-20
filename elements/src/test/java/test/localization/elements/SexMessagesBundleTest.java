package test.localization.elements;

import com.lapsa.insurance.elements.Sex;

import test.localization.EnumTypeMessagesBundleTest;

public class SexMessagesBundleTest extends EnumTypeMessagesBundleTest<Sex> {

    @Override
    protected Sex[] getAllEnumValues() {
	return Sex.values();
    }
}
