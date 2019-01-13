package test.localization.elements;

import com.lapsa.insurance.elements.SteeringWheelLocation;

import test.localization.ElementsLocalizationTest;

public class SteeringWheelLocationEnglishTest extends ElementsLocalizationTest<SteeringWheelLocation> {

    public SteeringWheelLocationEnglishTest() {
	super(SteeringWheelLocation.values(), SteeringWheelLocation.class, LOCALE_ENGLISH);
    }
}
