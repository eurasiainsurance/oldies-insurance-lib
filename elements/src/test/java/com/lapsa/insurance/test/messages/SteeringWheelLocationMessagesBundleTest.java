package com.lapsa.insurance.test.messages;

import com.lapsa.insurance.elements.SteeringWheelLocation;

public class SteeringWheelLocationMessagesBundleTest extends EnumTypeMessagesBundleTest<SteeringWheelLocation> {
    @Override
    protected SteeringWheelLocation[] getAllEnumValues() {
	return SteeringWheelLocation.values();
    }

    @Override
    protected String getBundleBaseName() {
	return SteeringWheelLocation.BUNDLE_BASENAME;
    }
}
