package test.localization.elements;

import com.lapsa.insurance.elements.VehicleClass;

import test.localization.ElementsLocalizationTest;

public class VehicleClassKazakhTest extends ElementsLocalizationTest<VehicleClass> {

    public VehicleClassKazakhTest() {
	super(VehicleClass.values(), VehicleClass.class, LOCALE_KAZAKH);
    }
}
