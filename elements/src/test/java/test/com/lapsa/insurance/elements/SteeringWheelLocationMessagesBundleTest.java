package test.com.lapsa.insurance.elements;

import com.lapsa.insurance.elements.SteeringWheelLocation;

import test.com.lapsa.insurance.EnumTypeMessagesBundleTest;

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
