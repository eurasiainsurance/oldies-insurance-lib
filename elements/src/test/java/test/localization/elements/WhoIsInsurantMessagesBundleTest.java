package test.localization.elements;

import com.lapsa.insurance.elements.WhoIsInsurant;

import test.localization.EnumTypeMessagesBundleTest;

public class WhoIsInsurantMessagesBundleTest extends EnumTypeMessagesBundleTest<WhoIsInsurant> {

    @Override
    protected WhoIsInsurant[] getAllEnumValues() {
	return WhoIsInsurant.values();
    }
}
