package test.localization.elements;

import com.lapsa.insurance.elements.MaritalStatus;

import test.localization.ElementsLocalizationTest;

public class MaritalStatusRussianTest extends ElementsLocalizationTest<MaritalStatus> {

    public MaritalStatusRussianTest() {
	super(MaritalStatus.values(), MaritalStatus.class, LOCALE_RUSSIAN);
    }
}
