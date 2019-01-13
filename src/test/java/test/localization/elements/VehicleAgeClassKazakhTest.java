package test.localization.elements;

import com.lapsa.insurance.elements.VehicleAgeClass;

import test.localization.ElementsLocalizationTest;

public class VehicleAgeClassKazakhTest extends ElementsLocalizationTest<VehicleAgeClass> {

    public VehicleAgeClassKazakhTest() {
	super(VehicleAgeClass.values(), VehicleAgeClass.class, LOCALE_KAZAKH);
    }
}
