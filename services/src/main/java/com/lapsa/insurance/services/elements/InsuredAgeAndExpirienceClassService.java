package com.lapsa.insurance.services.elements;

import com.lapsa.commons.elements.NamingListingService;
import com.lapsa.insurance.elements.InsuredAgeAndExpirienceClass;

public interface InsuredAgeAndExpirienceClassService extends NamingListingService<InsuredAgeAndExpirienceClass> {

    @Override
    default InsuredAgeAndExpirienceClass[] getAll() {
	return InsuredAgeAndExpirienceClass.values();
    }

    @Override
    default InsuredAgeAndExpirienceClass[] getSelectable() {
	return InsuredAgeAndExpirienceClass.values();
    }

    @Override
    default InsuredAgeAndExpirienceClass[] getNonSelectable() {
	return new InsuredAgeAndExpirienceClass[0];
    }
}
