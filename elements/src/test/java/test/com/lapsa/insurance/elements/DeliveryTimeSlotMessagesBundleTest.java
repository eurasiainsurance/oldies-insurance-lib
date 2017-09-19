package test.com.lapsa.insurance.elements;

import com.lapsa.insurance.elements.DeliveryTimeSlot;

import test.com.lapsa.insurance.EnumTypeMessagesBundleTest;

public class DeliveryTimeSlotMessagesBundleTest extends EnumTypeMessagesBundleTest<DeliveryTimeSlot> {

    @Override
    protected DeliveryTimeSlot[] getAllEnumValues() {
	return DeliveryTimeSlot.values();
    }
}
