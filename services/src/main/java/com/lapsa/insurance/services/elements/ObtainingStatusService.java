package com.lapsa.insurance.services.elements;

import com.lapsa.commons.elements.NamingListingService;
import com.lapsa.insurance.elements.ObtainingStatus;

public interface ObtainingStatusService extends NamingListingService<ObtainingStatus> {

    @Override
    default ObtainingStatus[] getAll() {
	return ObtainingStatus.values();
    }

    @Override
    default ObtainingStatus[] getSelectable() {
	return ObtainingStatus.selectableValues();
    }

    @Override
    default ObtainingStatus[] getNonSelectable() {
	return ObtainingStatus.nonSelectableValues();
    }
}
