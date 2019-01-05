package test.localization.elements;

import com.lapsa.insurance.elements.RequestCancelationReason;

import test.localization.ElementsLocalizationTest;

public class RequestCancelationReasonEnglishTest extends ElementsLocalizationTest<RequestCancelationReason> {

    public RequestCancelationReasonEnglishTest() {
	super(RequestCancelationReason.values(), RequestCancelationReason.class, LOCALE_ENGLISH);
    }
}
