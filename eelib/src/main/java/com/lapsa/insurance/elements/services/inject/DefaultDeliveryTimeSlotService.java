package com.lapsa.insurance.elements.services.inject;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.insurance.elements.DeliveryTimeSlot;
import com.lapsa.insurance.elements.services.DeliveryTimeSlotService;

@Named("deliveryTimeSlotService")
@ApplicationScoped
public class DefaultDeliveryTimeSlotService extends EnumService<DeliveryTimeSlot> implements DeliveryTimeSlotService {

    public List<DeliveryTimeSlot> getAllItems() {
	return CollectionUtils.toList(DeliveryTimeSlot.values());
    }

    @Override
    protected String getMessageBundleBase() {
	return DeliveryTimeSlot.BUNDLE_BASENAME;
    }

    @Override
    protected String getMessageBundleName() {
	return DeliveryTimeSlot.BUNDLE_VAR;
    }
}
