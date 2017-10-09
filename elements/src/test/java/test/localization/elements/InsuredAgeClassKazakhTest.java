package test.localization.elements;

import com.lapsa.insurance.elements.InsuredAgeClass;

import test.localization.ElementsLocalizationTest;

public class InsuredAgeClassKazakhTest extends ElementsLocalizationTest<InsuredAgeClass> {

    public InsuredAgeClassKazakhTest() {
	super(InsuredAgeClass.values(), InsuredAgeClass.class, LOCALE_KAZAKH);
    }
}
