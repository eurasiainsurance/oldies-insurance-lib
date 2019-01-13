package test.localization.elements;

import com.lapsa.insurance.elements.IdentityCardType;

import test.localization.ElementsLocalizationTest;

public class IdentityCardTypeEnglishTest extends ElementsLocalizationTest<IdentityCardType> {

    public IdentityCardTypeEnglishTest() {
	super(IdentityCardType.values(), IdentityCardType.class, LOCALE_ENGLISH);
    }
}
