package com.lapsa.insurance.services.elements;

import com.lapsa.commons.elements.NamingListingService;
import com.lapsa.insurance.elements.IdentityCardType;

public interface IdentityCardTypeService extends NamingListingService<IdentityCardType> {

    @Override
    default IdentityCardType[] getAll() {
	return IdentityCardType.values();
    }

    @Override
    default IdentityCardType[] getSelectable() {
	return IdentityCardType.selectableValues();
    }

    @Override
    default IdentityCardType[] getNonSelectable() {
	return IdentityCardType.nonSelectableValues();
    }
}
