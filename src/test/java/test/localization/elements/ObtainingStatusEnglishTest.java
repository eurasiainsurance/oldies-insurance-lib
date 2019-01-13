package test.localization.elements;

import com.lapsa.insurance.elements.ObtainingStatus;

import test.localization.ElementsLocalizationTest;

public class ObtainingStatusEnglishTest extends ElementsLocalizationTest<ObtainingStatus> {

    public ObtainingStatusEnglishTest() {
	super(ObtainingStatus.values(), ObtainingStatus.class, LOCALE_ENGLISH);
    }
}
