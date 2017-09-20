package test.localization.elements;

import com.lapsa.insurance.elements.VehicleClass;

import test.localization.EnumTypeMessagesBundleTest;

public class VehicleClassMessagesBundleTest extends EnumTypeMessagesBundleTest<VehicleClass> {

    @Override
    protected VehicleClass[] getAllEnumValues() {
	return VehicleClass.values();
    }
}
