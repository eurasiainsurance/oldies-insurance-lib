package com.lapsa.insurance.services.elements;

import com.lapsa.commons.elements.NamingListingService;
import com.lapsa.insurance.elements.CancelationReason;

public interface CancelationReasonService extends NamingListingService<CancelationReason> {

    @Override
    default CancelationReason[] getAll() {
	return CancelationReason.values();
    }

    @Override
    default CancelationReason[] getSelectable() {
	return CancelationReason.values();
    }

    @Override
    default CancelationReason[] getNonSelectable() {
	return new CancelationReason[0];
    }
}
