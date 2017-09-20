package test.localization.elements;

import com.lapsa.insurance.elements.SteeringWheelLocation;

import test.localization.EnumTypeMessagesBundleTest;

public class SteeringWheelLocationMessagesBundleTest extends EnumTypeMessagesBundleTest<SteeringWheelLocation> {
    @Override
    protected SteeringWheelLocation[] getAllEnumValues() {
	return SteeringWheelLocation.values();
    }
}
