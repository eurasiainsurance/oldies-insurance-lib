package test.localization.elements;

import com.lapsa.insurance.elements.ProgressStatus;

import test.localization.ElementsLocalizationTest;

public class ProgressStatusRussianTest extends ElementsLocalizationTest<ProgressStatus> {

    public ProgressStatusRussianTest() {
	super(ProgressStatus.values(), ProgressStatus.class, LOCALE_RUSSIAN);
    }
}
