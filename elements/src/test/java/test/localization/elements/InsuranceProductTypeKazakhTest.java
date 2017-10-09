package test.localization.elements;

import com.lapsa.insurance.elements.InsuranceProductType;

import test.localization.ElementsLocalizationTest;

public class InsuranceProductTypeKazakhTest extends ElementsLocalizationTest<InsuranceProductType> {

    public InsuranceProductTypeKazakhTest() {
	super(InsuranceProductType.values(), InsuranceProductType.class, LOCALE_KAZAKH);
    }
}
