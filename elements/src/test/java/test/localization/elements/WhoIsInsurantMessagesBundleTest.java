package test.com.lapsa.insurance.elements;

import com.lapsa.insurance.elements.WhoIsInsurant;

import test.com.lapsa.insurance.EnumTypeMessagesBundleTest;

public class WhoIsInsurantMessagesBundleTest extends EnumTypeMessagesBundleTest<WhoIsInsurant> {

    @Override
    protected WhoIsInsurant[] getAllEnumValues() {
	return WhoIsInsurant.values();
    }
}
