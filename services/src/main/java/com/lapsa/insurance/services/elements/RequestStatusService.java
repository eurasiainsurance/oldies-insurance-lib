package com.lapsa.insurance.services.elements;

import com.lapsa.commons.elements.NamingListingService;
import com.lapsa.insurance.elements.RequestStatus;

public interface RequestStatusService extends NamingListingService<RequestStatus> {

    @Override
    default RequestStatus[] getAll() {
	return RequestStatus.values();
    }

    @Override
    default RequestStatus[] getSelectable() {
	return RequestStatus.selectableValues();
    }

    @Override
    default RequestStatus[] getNonSelectable() {
	return RequestStatus.nonSelectableValues();
    }
}
