package test.localization.elements;

import com.lapsa.insurance.elements.RequestCancelationReason;

import test.localization.ElementsLocalizationTest;

public class RequestCancelationReasonRussianTest extends ElementsLocalizationTest<RequestCancelationReason> {

    public RequestCancelationReasonRussianTest() {
	super(RequestCancelationReason.values(), RequestCancelationReason.class, LOCALE_RUSSIAN);
    }
}
