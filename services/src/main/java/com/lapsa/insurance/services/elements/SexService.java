package com.lapsa.insurance.services.elements;

import com.lapsa.commons.elements.NamingListingService;
import com.lapsa.insurance.elements.Sex;

public interface SexService extends NamingListingService<Sex> {

    @Override
    default Sex[] getAll() {
	return Sex.values();
    }

    @Override
    default Sex[] getSelectable() {
	return Sex.selectableValues();
    }

    @Override
    default Sex[] getNonSelectable() {
	return Sex.nonSelectableValues();
    }
}
