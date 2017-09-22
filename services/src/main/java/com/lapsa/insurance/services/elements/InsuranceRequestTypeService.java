package com.lapsa.insurance.services.elements;

import com.lapsa.commons.elements.NamingListingService;
import com.lapsa.insurance.elements.InsuranceRequestType;

public interface InsuranceRequestTypeService extends NamingListingService<InsuranceRequestType> {

    @Override
    default InsuranceRequestType[] getAll() {
	return InsuranceRequestType.values();
    }

    @Override
    default InsuranceRequestType[] getSelectable() {
	return InsuranceRequestType.selectableValues();
    }

    @Override
    default InsuranceRequestType[] getNonSelectable() {
	return InsuranceRequestType.nonSelectableValues();
    }
}
