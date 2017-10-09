package test.localization.elements;

import com.lapsa.insurance.elements.ProgressStatus;

import test.localization.ElementsLocalizationTest;

public class ProgressStatusEnglishTest extends ElementsLocalizationTest<ProgressStatus> {

    public ProgressStatusEnglishTest() {
	super(ProgressStatus.values(), ProgressStatus.class, LOCALE_ENGLISH);
    }
}
