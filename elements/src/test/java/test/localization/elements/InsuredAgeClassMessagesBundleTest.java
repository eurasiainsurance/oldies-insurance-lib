package test.localization.elements;

import com.lapsa.insurance.elements.InsuredAgeClass;

import test.localization.EnumTypeMessagesBundleTest;

public class InsuredAgeClassMessagesBundleTest extends EnumTypeMessagesBundleTest<InsuredAgeClass> {

    @Override
    protected InsuredAgeClass[] getAllEnumValues() {
	return InsuredAgeClass.values();
    }
}
