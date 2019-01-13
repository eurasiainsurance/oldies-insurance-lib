package test.localization.elements;

import com.lapsa.insurance.elements.ProgressStatus;

import test.localization.ElementsLocalizationTest;

public class ProgressStatusKazakhTest extends ElementsLocalizationTest<ProgressStatus> {

    public ProgressStatusKazakhTest() {
	super(ProgressStatus.values(), ProgressStatus.class, LOCALE_KAZAKH);
    }
}
