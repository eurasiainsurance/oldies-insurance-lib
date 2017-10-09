package test.localization.elements;

import com.lapsa.insurance.elements.InsuranceClassType;

import test.localization.ElementsLocalizationTest;

public class InsuranceClassTypeEnglishTest extends ElementsLocalizationTest<InsuranceClassType> {

    public InsuranceClassTypeEnglishTest() {
	super(InsuranceClassType.values(), InsuranceClassType.class, LOCALE_ENGLISH);
    }
}
