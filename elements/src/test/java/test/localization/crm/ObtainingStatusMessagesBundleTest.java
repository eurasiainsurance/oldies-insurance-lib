package test.localization.crm;

import com.lapsa.insurance.elements.ObtainingStatus;

import test.localization.EnumTypeMessagesBundleTest;

public class ObtainingStatusMessagesBundleTest extends EnumTypeMessagesBundleTest<ObtainingStatus> {

    @Override
    protected ObtainingStatus[] getAllEnumValues() {
	return ObtainingStatus.values();
    }
}
