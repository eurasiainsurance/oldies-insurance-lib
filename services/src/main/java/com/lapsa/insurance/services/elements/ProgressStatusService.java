package com.lapsa.insurance.services.elements;

import com.lapsa.commons.elements.NamingListingService;
import com.lapsa.insurance.elements.ProgressStatus;

public interface ProgressStatusService extends NamingListingService<ProgressStatus> {

    @Override
    default ProgressStatus[] getAll() {
	return ProgressStatus.values();
    }

    @Override
    default ProgressStatus[] getSelectable() {
	return ProgressStatus.selectableValues();
    }

    @Override
    default ProgressStatus[] getNonSelectable() {
	return ProgressStatus.nonSelectableValues();
    }
}
