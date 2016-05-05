package test.com.lapsa.insurance.elements;

import com.lapsa.insurance.elements.VehicleAgeClass;

public class VehicleAgeClassMessagesBundleTest extends EnumTypeMessagesBundleTest<VehicleAgeClass> {

    @Override
    protected VehicleAgeClass[] getAllEnumValues() {
	return VehicleAgeClass.values();
    }

    @Override
    protected String getBundleBaseName() {
	return VehicleAgeClass.BUNDLE_BASENAME;
    }

}
