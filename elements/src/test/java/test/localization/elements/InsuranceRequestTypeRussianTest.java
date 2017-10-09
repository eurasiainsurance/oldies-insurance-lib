package test.localization.elements;

import com.lapsa.insurance.elements.InsuranceRequestType;

import test.localization.ElementsLocalizationTest;

public class InsuranceRequestTypeRussianTest extends ElementsLocalizationTest<InsuranceRequestType> {

    public InsuranceRequestTypeRussianTest() {
	super(InsuranceRequestType.values(), InsuranceRequestType.class, LOCALE_RUSSIAN);
    }
}
