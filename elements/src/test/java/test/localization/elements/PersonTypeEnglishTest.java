package test.localization.elements;

import com.lapsa.insurance.elements.PersonType;

import test.localization.ElementsLocalizationTest;

public class PersonTypeEnglishTest extends ElementsLocalizationTest<PersonType> {

    public PersonTypeEnglishTest() {
	super(PersonType.values(), PersonType.class, LOCALE_ENGLISH);
    }
}
