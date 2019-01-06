package test.localization.elements;

import com.lapsa.insurance.elements.InsuranceRequestCancellationReason;

import test.localization.ElementsLocalizationTest;

public class InsuranceRequestCancelationReasonRussianTest extends ElementsLocalizationTest<InsuranceRequestCancellationReason> {

    public InsuranceRequestCancelationReasonRussianTest() {
	super(InsuranceRequestCancellationReason.values(), InsuranceRequestCancellationReason.class, LOCALE_RUSSIAN);
    }
}
