package test.localization.elements;

import com.lapsa.insurance.elements.InsuredExpirienceClass;

import test.localization.ElementsLocalizationTest;

public class InsuredExpirienceClassRussianTest extends ElementsLocalizationTest<InsuredExpirienceClass> {

    public InsuredExpirienceClassRussianTest() {
	super(InsuredExpirienceClass.values(), InsuredExpirienceClass.class, LOCALE_RUSSIAN);
    }
}
