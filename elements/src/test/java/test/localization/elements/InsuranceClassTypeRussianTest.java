package test.localization.elements;

import com.lapsa.insurance.elements.InsuranceClassType;

import test.localization.ElementsLocalizationTest;

public class InsuranceClassTypeRussianTest extends ElementsLocalizationTest<InsuranceClassType> {

    public InsuranceClassTypeRussianTest() {
	super(InsuranceClassType.values(), InsuranceClassType.class, LOCALE_RUSSIAN);
    }
}
