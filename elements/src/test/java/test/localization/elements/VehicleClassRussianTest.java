package test.localization.elements;

import com.lapsa.insurance.elements.VehicleClass;

import test.localization.ElementsLocalizationTest;

public class VehicleClassRussianTest extends ElementsLocalizationTest<VehicleClass> {

    public VehicleClassRussianTest() {
	super(VehicleClass.values(), VehicleClass.class, LOCALE_RUSSIAN);
    }
}
