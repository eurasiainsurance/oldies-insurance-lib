package com.lapsa.insurance.services.elements;

import com.lapsa.commons.elements.NamingListingService;
import com.lapsa.insurance.elements.PaymentMethod;

public interface PaymentMethodService extends NamingListingService<PaymentMethod> {

    @Override
    default PaymentMethod[] getAll() {
	return PaymentMethod.values();
    }

    @Override
    default PaymentMethod[] getSelectable() {
	return PaymentMethod.selectableValues();
    }

    @Override
    default PaymentMethod[] getNonSelectable() {
	return PaymentMethod.nonSelectableValues();
    }
}
