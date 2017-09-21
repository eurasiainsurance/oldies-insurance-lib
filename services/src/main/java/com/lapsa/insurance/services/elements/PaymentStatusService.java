package com.lapsa.insurance.services.elements;

import com.lapsa.commons.elements.NamingListingService;
import com.lapsa.insurance.elements.PaymentStatus;

public interface PaymentStatusService extends NamingListingService<PaymentStatus> {

    @Override
    default PaymentStatus[] getAll() {
	return PaymentStatus.values();
    }

    @Override
    default PaymentStatus[] getSelectable() {
	return PaymentStatus.selectableValues();
    }

    @Override
    default PaymentStatus[] getNonSelectable() {
	return PaymentStatus.nonSelectableValues();
    }
}
