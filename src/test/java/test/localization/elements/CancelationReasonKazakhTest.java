package test.localization.elements;

import com.lapsa.insurance.elements.CancelationReason;

import test.localization.ElementsLocalizationTest;

public class CancelationReasonKazakhTest extends ElementsLocalizationTest<CancelationReason> {

    public CancelationReasonKazakhTest() {
	super(CancelationReason.values(), CancelationReason.class, LOCALE_KAZAKH);
    }
}
