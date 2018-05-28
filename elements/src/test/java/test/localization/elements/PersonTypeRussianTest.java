package test.localization.elements;

import com.lapsa.insurance.elements.PersonType;

import test.localization.ElementsLocalizationTest;

public class PersonTypeRussianTest extends ElementsLocalizationTest<PersonType> {

    public PersonTypeRussianTest() {
	super(PersonType.values(), PersonType.class, LOCALE_RUSSIAN);
    }
}
