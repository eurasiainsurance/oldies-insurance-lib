package test.localization.elements;

import com.lapsa.insurance.elements.DeliveryTimeSlot;

import test.localization.EnumTypeMessagesBundleTest;

public class DeliveryTimeSlotMessagesBundleTest extends EnumTypeMessagesBundleTest<DeliveryTimeSlot> {

    @Override
    protected DeliveryTimeSlot[] getAllEnumValues() {
	return DeliveryTimeSlot.values();
    }
}
