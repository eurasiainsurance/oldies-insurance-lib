package test.localization.elements;

import com.lapsa.insurance.elements.RequestSource;

import test.localization.ElementsLocalizationTest;

public class RequestSourceEnglishTest extends ElementsLocalizationTest<RequestSource> {

    public RequestSourceEnglishTest() {
	super(RequestSource.values(), RequestSource.class, LOCALE_ENGLISH);
    }
}
