package test.localization.elements;

import com.lapsa.insurance.elements.DeliveryTimeSlot;

import test.localization.ElementsLocalizationTest;

public class DeliveryTimeSlotEnglishTest extends ElementsLocalizationTest<DeliveryTimeSlot> {

    public DeliveryTimeSlotEnglishTest() {
	super(DeliveryTimeSlot.values(), DeliveryTimeSlot.class, LOCALE_ENGLISH);
    }
}
