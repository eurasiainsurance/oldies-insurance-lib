package com.lapsa.insurance.test.messages;

import com.lapsa.insurance.elements.VehicleAgeClass;

public class VehicleAgeClassMessagesBundleTest extends EnumTypeMessagesBundleTest<VehicleAgeClass> {

    @Override
    protected VehicleAgeClass[] getAllEnumValues() {
	return VehicleAgeClass.values();
    }

    @Override
    protected String getBundleBaseName() {
	return VehicleAgeClass.BUNDLE_BASENAME;
    }

}
