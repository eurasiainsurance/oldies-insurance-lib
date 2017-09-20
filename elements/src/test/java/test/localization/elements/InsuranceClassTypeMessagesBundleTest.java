package test.localization.elements;

import com.lapsa.insurance.elements.InsuranceClassType;

import test.localization.EnumTypeMessagesBundleTest;

public class InsuranceClassTypeMessagesBundleTest extends EnumTypeMessagesBundleTest<InsuranceClassType> {

    @Override
    protected InsuranceClassType[] getAllEnumValues() {
	return InsuranceClassType.values();
    }
}
