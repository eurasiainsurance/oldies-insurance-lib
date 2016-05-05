package test.com.lapsa.insurance.elements;

import com.lapsa.insurance.elements.IdentityCardType;

public class IdentityCardTypeMessagesBundleTest extends EnumTypeMessagesBundleTest<IdentityCardType>{

    @Override
    protected IdentityCardType[] getAllEnumValues() {
	return IdentityCardType.values();
    }

    @Override
    protected String getBundleBaseName() {
	return IdentityCardType.BUNDLE_BASENAME;
    }
}
