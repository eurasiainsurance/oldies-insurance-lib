package test.localization.elements;

import com.lapsa.insurance.elements.InsuranceProductType;

import test.localization.ElementsLocalizationTest;

public class InsuranceProductTypeEnglishTest extends ElementsLocalizationTest<InsuranceProductType> {

    public InsuranceProductTypeEnglishTest() {
	super(InsuranceProductType.values(), InsuranceProductType.class, LOCALE_ENGLISH);
    }
}
