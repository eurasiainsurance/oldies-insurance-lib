package test.localization.elements;

import com.lapsa.insurance.elements.RequestCancelationReason;

import test.localization.ElementsLocalizationTest;

public class RequestCancelationReasonKazakhTest extends ElementsLocalizationTest<RequestCancelationReason> {

    public RequestCancelationReasonKazakhTest() {
	super(RequestCancelationReason.values(), RequestCancelationReason.class, LOCALE_KAZAKH);
    }
}
