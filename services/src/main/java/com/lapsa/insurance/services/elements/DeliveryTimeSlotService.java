package com.lapsa.insurance.services.elements;

import com.lapsa.commons.elements.NamingListingService;
import com.lapsa.insurance.elements.DeliveryTimeSlot;

public interface DeliveryTimeSlotService extends NamingListingService<DeliveryTimeSlot> {

    @Override
    default DeliveryTimeSlot[] getAll() {
	return DeliveryTimeSlot.values();
    }

    @Override
    default DeliveryTimeSlot[] getSelectable() {
	return DeliveryTimeSlot.selectableValues();
    }

    @Override
    default DeliveryTimeSlot[] getNonSelectable() {
	return DeliveryTimeSlot.nonSelectableValues();
    }
}
