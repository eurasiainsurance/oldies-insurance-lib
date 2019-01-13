package test.localization.elements;

import com.lapsa.insurance.elements.Sex;

import test.localization.ElementsLocalizationTest;

public class SexEnglishTest extends ElementsLocalizationTest<Sex> {

    public SexEnglishTest() {
	super(Sex.values(), Sex.class, LOCALE_ENGLISH);
    }
}
