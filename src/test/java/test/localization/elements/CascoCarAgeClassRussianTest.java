package test.localization.elements;

import com.lapsa.insurance.elements.CascoCarAgeClass;

import test.localization.ElementsLocalizationTest;

public class CascoCarAgeClassRussianTest extends ElementsLocalizationTest<CascoCarAgeClass> {

    public CascoCarAgeClassRussianTest() {
	super(CascoCarAgeClass.values(), CascoCarAgeClass.class, LOCALE_RUSSIAN);
    }
}
