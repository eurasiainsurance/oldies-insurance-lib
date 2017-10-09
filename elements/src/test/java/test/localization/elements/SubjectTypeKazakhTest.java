package test.localization.elements;

import com.lapsa.insurance.elements.SubjectType;

import test.localization.ElementsLocalizationTest;

public class SubjectTypeKazakhTest extends ElementsLocalizationTest<SubjectType> {

    public SubjectTypeKazakhTest() {
	super(SubjectType.values(), SubjectType.class, LOCALE_KAZAKH);
    }
}
