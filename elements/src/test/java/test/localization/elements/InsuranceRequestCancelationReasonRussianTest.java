package test.localization.elements;

import com.lapsa.insurance.elements.InsuranceRequestCancelationReason;

import test.localization.ElementsLocalizationTest;

public class InsuranceRequestCancelationReasonRussianTest extends ElementsLocalizationTest<InsuranceRequestCancelationReason> {

    public InsuranceRequestCancelationReasonRussianTest() {
	super(InsuranceRequestCancelationReason.values(), InsuranceRequestCancelationReason.class, LOCALE_RUSSIAN);
    }
}
