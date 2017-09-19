package test.com.lapsa.insurance.elements;

import com.lapsa.insurance.elements.MaritalStatus;

import test.com.lapsa.insurance.EnumTypeMessagesBundleTest;

public class MaritalStatusMessagesBundleTest extends EnumTypeMessagesBundleTest<MaritalStatus> {

    @Override
    protected MaritalStatus[] getAllEnumValues() {
	return MaritalStatus.values();
    }
}
