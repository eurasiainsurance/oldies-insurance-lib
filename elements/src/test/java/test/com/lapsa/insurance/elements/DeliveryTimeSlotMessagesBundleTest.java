package test.com.lapsa.insurance.elements;

import com.lapsa.insurance.elements.DeliveryTimeSlot;

public class DeliveryTimeSlotMessagesBundleTest extends EnumTypeMessagesBundleTest<DeliveryTimeSlot> {

    @Override
    protected DeliveryTimeSlot[] getAllEnumValues() {
	return DeliveryTimeSlot.values();
    }

    @Override
    protected String getBundleBaseName() {
	return DeliveryTimeSlot.BUNDLE_BASENAME;
    }
}
