package com.lapsa.insurance.services.elements.beans;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.insurance.elements.DeliveryTimeSlot;
import com.lapsa.insurance.services.elements.DeliveryTimeSlotService;

@Named("deliveryTimeSlotService")
@ApplicationScoped
public class DefaultDeliveryTimeSlotService extends GenericEnumService<DeliveryTimeSlot> implements DeliveryTimeSlotService {

    public List<DeliveryTimeSlot> getAllItems() {
	return Arrays.asList(DeliveryTimeSlot.values());
    }

    @Override
    protected String getMessageBundleBase() {
	return DeliveryTimeSlot.BUNDLE_BASENAME;
    }

    @Override
    protected String getMessageBundleVar() {
	return DeliveryTimeSlot.BUNDLE_VAR;
    }
}
