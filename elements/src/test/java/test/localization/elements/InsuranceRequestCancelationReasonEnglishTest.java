package test.localization.elements;

import com.lapsa.insurance.elements.InsuranceRequestCancelationReason;

import test.localization.ElementsLocalizationTest;

public class InsuranceRequestCancelationReasonEnglishTest extends ElementsLocalizationTest<InsuranceRequestCancelationReason> {

    public InsuranceRequestCancelationReasonEnglishTest() {
	super(InsuranceRequestCancelationReason.values(), InsuranceRequestCancelationReason.class, LOCALE_ENGLISH);
    }
}
