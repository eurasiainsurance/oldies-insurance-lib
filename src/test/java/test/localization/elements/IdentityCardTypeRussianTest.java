package test.localization.elements;

import com.lapsa.insurance.elements.IdentityCardType;

import test.localization.ElementsLocalizationTest;

public class IdentityCardTypeRussianTest extends ElementsLocalizationTest<IdentityCardType> {

    public IdentityCardTypeRussianTest() {
	super(IdentityCardType.values(), IdentityCardType.class, LOCALE_RUSSIAN);
    }
}
