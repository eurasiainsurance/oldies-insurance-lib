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
	return RequestStatus.values();
    }

    @Override
    default RequestStatus[] getNonSelectable() {
	return new RequestStatus[0];
    }
}
