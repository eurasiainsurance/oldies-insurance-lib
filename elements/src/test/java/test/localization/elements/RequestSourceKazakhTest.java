package test.localization.elements;

import com.lapsa.insurance.elements.RequestSource;

import test.localization.ElementsLocalizationTest;

public class RequestSourceKazakhTest extends ElementsLocalizationTest<RequestSource> {

    public RequestSourceKazakhTest() {
	super(RequestSource.values(), RequestSource.class, LOCALE_KAZAKH);
    }
}
