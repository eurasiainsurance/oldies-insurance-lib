package test.localization.elements;

import com.lapsa.insurance.elements.VehicleAgeClass;

import test.localization.ElementsLocalizationTest;

public class VehicleAgeClassEnglishTest extends ElementsLocalizationTest<VehicleAgeClass> {

    public VehicleAgeClassEnglishTest() {
	super(VehicleAgeClass.values(), VehicleAgeClass.class, LOCALE_ENGLISH);
    }
}
