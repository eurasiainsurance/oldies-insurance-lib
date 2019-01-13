package test.localization.elements;

import com.lapsa.insurance.elements.IdentityCardType;

import test.localization.ElementsLocalizationTest;

public class IdentityCardTypeKazakhTest extends ElementsLocalizationTest<IdentityCardType> {

    public IdentityCardTypeKazakhTest() {
	super(IdentityCardType.values(), IdentityCardType.class, LOCALE_KAZAKH);
    }
}
