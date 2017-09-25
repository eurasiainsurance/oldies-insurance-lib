package test.localization.elements;

import com.lapsa.insurance.elements.RequestStatus;

import test.localization.ElementsLocalizationTest;

public class RequestStatusKazakhTest extends ElementsLocalizationTest<RequestStatus> {

    public RequestStatusKazakhTest() {
	super(RequestStatus.values(), RequestStatus.class, LOCALE_KAZAKH);
    }
}
