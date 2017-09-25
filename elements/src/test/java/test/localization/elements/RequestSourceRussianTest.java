package test.localization.elements;

import com.lapsa.insurance.elements.RequestSource;

import test.localization.ElementsLocalizationTest;

public class RequestSourceRussianTest extends ElementsLocalizationTest<RequestSource> {

    public RequestSourceRussianTest() {
	super(RequestSource.values(), RequestSource.class, LOCALE_RUSSIAN);
    }
}
