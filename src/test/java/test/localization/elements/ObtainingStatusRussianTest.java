package test.localization.elements;

import com.lapsa.insurance.elements.ObtainingStatus;

import test.localization.ElementsLocalizationTest;

public class ObtainingStatusRussianTest extends ElementsLocalizationTest<ObtainingStatus> {

    public ObtainingStatusRussianTest() {
	super(ObtainingStatus.values(), ObtainingStatus.class, LOCALE_RUSSIAN);
    }
}
