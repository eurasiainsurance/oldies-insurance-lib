package com.lapsa.insurance.services.elements;

import com.lapsa.commons.elements.NamingListingService;
import com.lapsa.insurance.elements.RequestSource;

public interface RequestSourceService extends NamingListingService<RequestSource> {

    @Override
    default RequestSource[] getAll() {
	return RequestSource.values();
    }

    @Override
    default RequestSource[] getSelectable() {
	return RequestSource.values();
    }

    @Override
    default RequestSource[] getNonSelectable() {
	return new RequestSource[0];
    }
}
