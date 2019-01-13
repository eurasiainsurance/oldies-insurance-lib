package test.localization.elements;

import com.lapsa.insurance.elements.MaritalStatus;

import test.localization.ElementsLocalizationTest;

public class MaritalStatusEnglishTest extends ElementsLocalizationTest<MaritalStatus> {

    public MaritalStatusEnglishTest() {
	super(MaritalStatus.values(), MaritalStatus.class, LOCALE_ENGLISH);
    }
}
