package test.localization.elements;

import com.lapsa.insurance.elements.Sex;

import test.localization.ElementsLocalizationTest;

public class SexKazakhTest extends ElementsLocalizationTest<Sex> {

    public SexKazakhTest() {
	super(Sex.values(), Sex.class, LOCALE_KAZAKH);
    }
}
