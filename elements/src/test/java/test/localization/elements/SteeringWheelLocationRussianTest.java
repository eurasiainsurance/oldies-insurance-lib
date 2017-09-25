package test.localization.elements;

import com.lapsa.insurance.elements.SteeringWheelLocation;

import test.localization.ElementsLocalizationTest;

public class SteeringWheelLocationRussianTest extends ElementsLocalizationTest<SteeringWheelLocation> {

    public SteeringWheelLocationRussianTest() {
	super(SteeringWheelLocation.values(), SteeringWheelLocation.class, LOCALE_RUSSIAN);
    }
}
