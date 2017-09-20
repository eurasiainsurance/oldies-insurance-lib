package test.localization.elements;

import com.lapsa.insurance.elements.InsuranceProductType;

import test.localization.EnumTypeMessagesBundleTest;

public class InsuranceProductTypeMessagesBundleTest extends EnumTypeMessagesBundleTest<InsuranceProductType> {

    @Override
    protected InsuranceProductType[] getAllEnumValues() {
	return InsuranceProductType.values();
    }
}
