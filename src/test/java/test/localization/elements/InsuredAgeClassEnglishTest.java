package test.localization.elements;

import com.lapsa.insurance.elements.InsuredAgeClass;

import test.localization.ElementsLocalizationTest;

public class InsuredAgeClassEnglishTest extends ElementsLocalizationTest<InsuredAgeClass> {

    public InsuredAgeClassEnglishTest() {
	super(InsuredAgeClass.values(), InsuredAgeClass.class, LOCALE_ENGLISH);
    }
}
