package test.localization.elements;

import com.lapsa.insurance.elements.InsuranceRequestType;

import test.localization.ElementsLocalizationTest;

public class InsuranceRequestTypeKazakhTest extends ElementsLocalizationTest<InsuranceRequestType> {

    public InsuranceRequestTypeKazakhTest() {
	super(InsuranceRequestType.values(), InsuranceRequestType.class, LOCALE_KAZAKH);
    }
}
