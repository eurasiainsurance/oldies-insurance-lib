package test.localization.elements;

import com.lapsa.insurance.elements.IdentityCardType;

import test.localization.EnumTypeMessagesBundleTest;

public class IdentityCardTypeMessagesBundleTest extends EnumTypeMessagesBundleTest<IdentityCardType> {

    @Override
    protected IdentityCardType[] getAllEnumValues() {
	return IdentityCardType.values();
    }
}
