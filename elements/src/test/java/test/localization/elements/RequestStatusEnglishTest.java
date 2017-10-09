package test.localization.elements;

import com.lapsa.insurance.elements.RequestStatus;

import test.localization.ElementsLocalizationTest;

public class RequestStatusEnglishTest extends ElementsLocalizationTest<RequestStatus> {

    public RequestStatusEnglishTest() {
	super(RequestStatus.values(), RequestStatus.class, LOCALE_ENGLISH);
    }
}
