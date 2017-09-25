package test.localization.elements;

import com.lapsa.insurance.elements.WhoIsInsurant;

import test.localization.ElementsLocalizationTest;

public class WhoIsInsurantEnglishTest extends ElementsLocalizationTest<WhoIsInsurant> {

    public WhoIsInsurantEnglishTest() {
	super(WhoIsInsurant.values(), WhoIsInsurant.class, LOCALE_ENGLISH);
    }
}
