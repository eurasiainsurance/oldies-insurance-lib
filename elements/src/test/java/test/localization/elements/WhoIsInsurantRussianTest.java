package test.localization.elements;

import com.lapsa.insurance.elements.WhoIsInsurant;

import test.localization.ElementsLocalizationTest;

public class WhoIsInsurantRussianTest extends ElementsLocalizationTest<WhoIsInsurant> {

    public WhoIsInsurantRussianTest() {
	super(WhoIsInsurant.values(), WhoIsInsurant.class, LOCALE_RUSSIAN);
    }
}
