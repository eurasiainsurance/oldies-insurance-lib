package test.localization.elements;

import com.lapsa.insurance.elements.InsuranceProductType;

import test.localization.ElementsLocalizationTest;

public class InsuranceProductTypeRussianTest extends ElementsLocalizationTest<InsuranceProductType> {

    public InsuranceProductTypeRussianTest() {
	super(InsuranceProductType.values(), InsuranceProductType.class, LOCALE_RUSSIAN);
    }
}
