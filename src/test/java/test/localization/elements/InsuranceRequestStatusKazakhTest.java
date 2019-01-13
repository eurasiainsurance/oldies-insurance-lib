package test.localization.elements;

import com.lapsa.insurance.elements.InsuranceRequestStatus;

import test.localization.ElementsLocalizationTest;

public class InsuranceRequestStatusKazakhTest extends ElementsLocalizationTest<InsuranceRequestStatus> {

    public InsuranceRequestStatusKazakhTest() {
	super(InsuranceRequestStatus.values(), InsuranceRequestStatus.class, LOCALE_KAZAKH);
    }
}
