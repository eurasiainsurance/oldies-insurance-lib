package test.com.lapsa.insurance.elements;

import com.lapsa.insurance.elements.VehicleAgeClass;

import test.com.lapsa.insurance.EnumTypeMessagesBundleTest;

public class VehicleAgeClassMessagesBundleTest extends EnumTypeMessagesBundleTest<VehicleAgeClass> {

    @Override
    protected VehicleAgeClass[] getAllEnumValues() {
	return VehicleAgeClass.values();
    }
}
