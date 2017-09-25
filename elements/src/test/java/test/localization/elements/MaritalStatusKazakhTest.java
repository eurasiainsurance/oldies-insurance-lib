package test.localization.elements;

import com.lapsa.insurance.elements.MaritalStatus;

import test.localization.ElementsLocalizationTest;

public class MaritalStatusKazakhTest extends ElementsLocalizationTest<MaritalStatus> {

    public MaritalStatusKazakhTest() {
	super(MaritalStatus.values(), MaritalStatus.class, LOCALE_KAZAKH);
    }
}
