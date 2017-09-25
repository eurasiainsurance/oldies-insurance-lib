package test.localization.elements;

import com.lapsa.insurance.elements.CancelationReason;

import test.localization.ElementsLocalizationTest;

public class CancelationReasonRussianTest extends ElementsLocalizationTest<CancelationReason> {

    public CancelationReasonRussianTest() {
	super(CancelationReason.values(), CancelationReason.class, LOCALE_RUSSIAN);
    }
}
