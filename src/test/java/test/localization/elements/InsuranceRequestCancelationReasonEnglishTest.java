package test.localization.elements;

import com.lapsa.insurance.elements.InsuranceRequestCancellationReason;

import test.localization.ElementsLocalizationTest;

public class InsuranceRequestCancelationReasonEnglishTest extends ElementsLocalizationTest<InsuranceRequestCancellationReason> {

    public InsuranceRequestCancelationReasonEnglishTest() {
	super(InsuranceRequestCancellationReason.values(), InsuranceRequestCancellationReason.class, LOCALE_ENGLISH);
    }
}
