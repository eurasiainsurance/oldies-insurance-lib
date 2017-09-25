package test.localization.elements;

import com.lapsa.insurance.elements.InsuranceClassType;

import test.localization.ElementsLocalizationTest;

public class InsuranceClassTypeKazakhTest extends ElementsLocalizationTest<InsuranceClassType> {

    public InsuranceClassTypeKazakhTest() {
	super(InsuranceClassType.values(), InsuranceClassType.class, LOCALE_KAZAKH);
    }
}
