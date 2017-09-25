package test.localization.elements;

import com.lapsa.insurance.elements.SubjectType;

import test.localization.ElementsLocalizationTest;

public class SubjectTypeRussianTest extends ElementsLocalizationTest<SubjectType> {

    public SubjectTypeRussianTest() {
	super(SubjectType.values(), SubjectType.class, LOCALE_RUSSIAN);
    }
}
