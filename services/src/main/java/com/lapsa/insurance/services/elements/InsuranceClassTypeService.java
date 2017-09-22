package com.lapsa.insurance.services.elements;

import com.lapsa.commons.elements.NamingListingService;
import com.lapsa.insurance.elements.InsuranceClassType;

public interface InsuranceClassTypeService extends NamingListingService<InsuranceClassType> {

    @Override
    default InsuranceClassType[] getAll() {
	return InsuranceClassType.values();
    }

    @Override
    default InsuranceClassType[] getSelectable() {
	return InsuranceClassType.selectableValues();
    }

    @Override
    default InsuranceClassType[] getNonSelectable() {
	return InsuranceClassType.nonSelectableValues();
    }
}
