package com.lapsa.insurance.services.elements;

import com.lapsa.commons.elements.NamingListingService;
import com.lapsa.insurance.elements.InsuredAgeClass;

public interface InsuredAgeClassService extends NamingListingService<InsuredAgeClass> {

    @Override
    default InsuredAgeClass[] getAll() {
	return InsuredAgeClass.values();
    }

    @Override
    default InsuredAgeClass[] getSelectable() {
	return InsuredAgeClass.values();
    }

    @Override
    default InsuredAgeClass[] getNonSelectable() {
	return new InsuredAgeClass[0];
    }
}
