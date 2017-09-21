package com.lapsa.insurance.services.elements;

import com.lapsa.commons.elements.NamingListingService;
import com.lapsa.insurance.elements.WhoIsInsurant;

public interface WhoIsInsurantService extends NamingListingService<WhoIsInsurant> {

    @Override
    default WhoIsInsurant[] getAll() {
	return WhoIsInsurant.values();
    }

    @Override
    default WhoIsInsurant[] getSelectable() {
	return WhoIsInsurant.values();
    }

    @Override
    default WhoIsInsurant[] getNonSelectable() {
	return new WhoIsInsurant[0];
    }
}
