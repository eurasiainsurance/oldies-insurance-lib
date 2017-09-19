package test.com.lapsa.insurance.elements;

import com.lapsa.insurance.elements.VehicleClass;

import test.com.lapsa.insurance.EnumTypeMessagesBundleTest;

public class VehicleClassMessagesBundleTest extends EnumTypeMessagesBundleTest<VehicleClass> {

    @Override
    protected VehicleClass[] getAllEnumValues() {
	return VehicleClass.values();
    }
}
