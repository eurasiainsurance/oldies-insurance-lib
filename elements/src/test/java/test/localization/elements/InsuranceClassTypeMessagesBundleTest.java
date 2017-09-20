package test.com.lapsa.insurance.elements;

import com.lapsa.insurance.elements.InsuranceClassType;

import test.com.lapsa.insurance.EnumTypeMessagesBundleTest;

public class InsuranceClassTypeMessagesBundleTest extends EnumTypeMessagesBundleTest<InsuranceClassType> {

    @Override
    protected InsuranceClassType[] getAllEnumValues() {
	return InsuranceClassType.values();
    }
}
