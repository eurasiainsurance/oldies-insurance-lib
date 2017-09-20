package test.localization.elements;

import com.lapsa.insurance.elements.MaritalStatus;

import test.localization.EnumTypeMessagesBundleTest;

public class MaritalStatusMessagesBundleTest extends EnumTypeMessagesBundleTest<MaritalStatus> {

    @Override
    protected MaritalStatus[] getAllEnumValues() {
	return MaritalStatus.values();
    }
}
