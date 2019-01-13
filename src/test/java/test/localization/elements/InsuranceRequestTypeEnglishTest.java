package test.localization.elements;

import com.lapsa.insurance.elements.InsuranceRequestType;

import test.localization.ElementsLocalizationTest;

public class InsuranceRequestTypeEnglishTest extends ElementsLocalizationTest<InsuranceRequestType> {

    public InsuranceRequestTypeEnglishTest() {
	super(InsuranceRequestType.values(), InsuranceRequestType.class, LOCALE_ENGLISH);
    }
}
