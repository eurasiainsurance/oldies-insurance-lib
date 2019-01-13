package test.localization.elements;

import com.lapsa.insurance.elements.Sex;

import test.localization.ElementsLocalizationTest;

public class SexRussianTest extends ElementsLocalizationTest<Sex> {

    public SexRussianTest() {
	super(Sex.values(), Sex.class, LOCALE_RUSSIAN);
    }
}
