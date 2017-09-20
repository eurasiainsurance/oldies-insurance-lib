package test.localization.elements;

import com.lapsa.insurance.elements.VehicleAgeClass;

import test.localization.EnumTypeMessagesBundleTest;

public class VehicleAgeClassMessagesBundleTest extends EnumTypeMessagesBundleTest<VehicleAgeClass> {

    @Override
    protected VehicleAgeClass[] getAllEnumValues() {
	return VehicleAgeClass.values();
    }
}
