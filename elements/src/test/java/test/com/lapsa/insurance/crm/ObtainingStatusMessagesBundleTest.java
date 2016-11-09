package test.com.lapsa.insurance.crm;

import com.lapsa.insurance.crm.ObtainingStatus;

import test.com.lapsa.insurance.EnumTypeMessagesBundleTest;

public class ObtainingStatusMessagesBundleTest extends EnumTypeMessagesBundleTest<ObtainingStatus> {

    @Override
    protected ObtainingStatus[] getAllEnumValues() {
	return ObtainingStatus.values();
    }

    @Override
    protected String getBundleBaseName() {
	return ObtainingStatus.BUNDLE_BASENAME;
    }
}
