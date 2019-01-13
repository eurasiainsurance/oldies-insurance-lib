package test.localization.elements;

import com.lapsa.insurance.elements.VehicleAgeClass;

import test.localization.ElementsLocalizationTest;

public class VehicleAgeClassRussianTest extends ElementsLocalizationTest<VehicleAgeClass> {

    public VehicleAgeClassRussianTest() {
	super(VehicleAgeClass.values(), VehicleAgeClass.class, LOCALE_RUSSIAN);
    }
}
