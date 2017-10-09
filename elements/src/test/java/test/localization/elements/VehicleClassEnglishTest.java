package test.localization.elements;

import com.lapsa.insurance.elements.VehicleClass;

import test.localization.ElementsLocalizationTest;

public class VehicleClassEnglishTest extends ElementsLocalizationTest<VehicleClass> {

    public VehicleClassEnglishTest() {
	super(VehicleClass.values(), VehicleClass.class, LOCALE_ENGLISH);
    }
}
