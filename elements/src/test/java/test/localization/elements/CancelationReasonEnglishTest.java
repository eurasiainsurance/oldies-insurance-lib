package test.localization.elements;

import com.lapsa.insurance.elements.CancelationReason;

import test.localization.ElementsLocalizationTest;

public class CancelationReasonEnglishTest extends ElementsLocalizationTest<CancelationReason> {

    public CancelationReasonEnglishTest() {
	super(CancelationReason.values(), CancelationReason.class, LOCALE_ENGLISH);
    }
}
