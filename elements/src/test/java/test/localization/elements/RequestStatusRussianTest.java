package test.localization.elements;

import com.lapsa.insurance.elements.RequestStatus;

import test.localization.ElementsLocalizationTest;

public class RequestStatusRussianTest extends ElementsLocalizationTest<RequestStatus> {

    public RequestStatusRussianTest() {
	super(RequestStatus.values(), RequestStatus.class, LOCALE_RUSSIAN);
    }
}
