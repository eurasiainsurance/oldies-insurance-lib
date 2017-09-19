package test.com.lapsa.insurance.elements;

import com.lapsa.insurance.elements.InsuranceProductType;

import test.com.lapsa.insurance.EnumTypeMessagesBundleTest;

public class InsuranceProductTypeMessagesBundleTest extends EnumTypeMessagesBundleTest<InsuranceProductType> {

    @Override
    protected InsuranceProductType[] getAllEnumValues() {
	return InsuranceProductType.values();
    }
}
