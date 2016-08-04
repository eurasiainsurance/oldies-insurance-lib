package test.com.lapsa.insurance.elements;

import com.lapsa.insurance.elements.CascoCarAgeClass;

import test.com.lapsa.insurance.EnumTypeMessagesBundleTest;

public class CascoCarAgeClassMessagesBundleTest extends EnumTypeMessagesBundleTest<CascoCarAgeClass> {

    @Override
    protected CascoCarAgeClass[] getAllEnumValues() {
	return CascoCarAgeClass.values();
    }

    @Override
    protected String getBundleBaseName() {
	return CascoCarAgeClass.BUNDLE_BASENAME;
    }
}
