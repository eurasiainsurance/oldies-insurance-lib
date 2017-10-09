package test.localization.elements;

import com.lapsa.insurance.elements.SubjectType;

import test.localization.ElementsLocalizationTest;

public class SubjectTypeEnglishTest extends ElementsLocalizationTest<SubjectType> {

    public SubjectTypeEnglishTest() {
	super(SubjectType.values(), SubjectType.class, LOCALE_ENGLISH);
    }
}
