package test.localization.elements;

import com.lapsa.insurance.elements.DeliveryTimeSlot;

import test.localization.ElementsLocalizationTest;

public class DeliveryTimeSlotRussianTest extends ElementsLocalizationTest<DeliveryTimeSlot> {

    public DeliveryTimeSlotRussianTest() {
	super(DeliveryTimeSlot.values(), DeliveryTimeSlot.class, LOCALE_RUSSIAN);
    }
}
