package com.lapsa.insurance.services.elements;

import com.lapsa.commons.elements.NamingListingService;
import com.lapsa.insurance.elements.InsuredExpirienceClass;

public interface InsuredExpirienceClassService extends NamingListingService<InsuredExpirienceClass> {

    @Override
    default InsuredExpirienceClass[] getAll() {
	return InsuredExpirienceClass.values();
    }

    @Override
    default InsuredExpirienceClass[] getSelectable() {
	return InsuredExpirienceClass.selectableValues();
    }

    @Override
    default InsuredExpirienceClass[] getNonSelectable() {
	return InsuredExpirienceClass.nonSelectableValues();
    }
}
