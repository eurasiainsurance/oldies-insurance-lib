package test.localization.elements;

import com.lapsa.insurance.elements.InsuredAgeClass;

import test.localization.ElementsLocalizationTest;

public class InsuredAgeClassRussianTest extends ElementsLocalizationTest<InsuredAgeClass> {

    public InsuredAgeClassRussianTest() {
	super(InsuredAgeClass.values(), InsuredAgeClass.class, LOCALE_RUSSIAN);
    }
}
