package test.localization.elements;

import com.lapsa.insurance.elements.PersonType;

import test.localization.ElementsLocalizationTest;

public class PersonTypeKazakhTest extends ElementsLocalizationTest<PersonType> {

    public PersonTypeKazakhTest() {
	super(PersonType.values(), PersonType.class, LOCALE_KAZAKH);
    }
}
