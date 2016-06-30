package test.com.lapsa.insurance.elements;

import com.lapsa.insurance.elements.InsuredAgeClass;

import test.com.lapsa.insurance.EnumTypeMessagesBundleTest;

public class InsuredAgeClassMessagesBundleTest extends EnumTypeMessagesBundleTest<InsuredAgeClass>{

    @Override
    protected InsuredAgeClass[] getAllEnumValues() {
	return InsuredAgeClass.values();
    }

    @Override
    protected String getBundleBaseName() {
	return InsuredAgeClass.BUNDLE_BASENAME;
    }
}
