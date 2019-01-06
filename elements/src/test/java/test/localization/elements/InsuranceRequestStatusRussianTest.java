package test.localization.elements;

import com.lapsa.insurance.elements.InsuranceRequestStatus;

import test.localization.ElementsLocalizationTest;

public class InsuranceRequestStatusRussianTest extends ElementsLocalizationTest<InsuranceRequestStatus> {

    public InsuranceRequestStatusRussianTest() {
	super(InsuranceRequestStatus.values(), InsuranceRequestStatus.class, LOCALE_RUSSIAN);
    }
}
