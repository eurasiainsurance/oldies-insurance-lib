package com.lapsa.insurance.services.elements;

import com.lapsa.commons.elements.NamingListingService;
import com.lapsa.insurance.elements.TransactionStatus;

public interface TransactionStatusService extends NamingListingService<TransactionStatus> {

    @Override
    default TransactionStatus[] getAll() {
	return TransactionStatus.values();
    }

    @Override
    default TransactionStatus[] getSelectable() {
	return TransactionStatus.values();
    }

    @Override
    default TransactionStatus[] getNonSelectable() {
	return new TransactionStatus[0];
    }
}
