package test.localization.elements;

import com.lapsa.insurance.elements.InsuranceRequestStatus;

import test.localization.ElementsLocalizationTest;

public class InsuranceRequestStatusEnglishTest extends ElementsLocalizationTest<InsuranceRequestStatus> {

    public InsuranceRequestStatusEnglishTest() {
	super(InsuranceRequestStatus.values(), InsuranceRequestStatus.class, LOCALE_ENGLISH);
    }
}
