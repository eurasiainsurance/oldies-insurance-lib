package com.lapsa.insurance.services.elements;

import com.lapsa.commons.elements.NamingListingService;
import com.lapsa.insurance.elements.InsuranceProductType;

public interface InsuranceProductTypeService extends NamingListingService<InsuranceProductType> {

    @Override
    default InsuranceProductType[] getAll() {
	return InsuranceProductType.values();
    }

    @Override
    default InsuranceProductType[] getSelectable() {
	return InsuranceProductType.selectableValues();
    }

    @Override
    default InsuranceProductType[] getNonSelectable() {
	return InsuranceProductType.nonSelectableValues();
    }
}
