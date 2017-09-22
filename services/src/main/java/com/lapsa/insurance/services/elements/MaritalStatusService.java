package com.lapsa.insurance.services.elements;

import com.lapsa.commons.elements.NamingListingService;
import com.lapsa.insurance.elements.MaritalStatus;

public interface MaritalStatusService extends NamingListingService<MaritalStatus> {

    @Override
    default MaritalStatus[] getAll() {
	return MaritalStatus.values();
    }

    @Override
    default MaritalStatus[] getSelectable() {
	return MaritalStatus.selectableValues();
    }

    @Override
    default MaritalStatus[] getNonSelectable() {
	return MaritalStatus.nonSelectableValues();
    }
}
