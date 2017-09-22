package com.lapsa.insurance.services.elements;

import com.lapsa.commons.elements.NamingListingService;
import com.lapsa.insurance.elements.CascoCarAgeClass;

public interface CascoCarAgeClassService extends NamingListingService<CascoCarAgeClass> {

    @Override
    default CascoCarAgeClass[] getAll() {
	return CascoCarAgeClass.values();
    }

    @Override
    default CascoCarAgeClass[] getSelectable() {
	return CascoCarAgeClass.selectableValues();
    }

    @Override
    default CascoCarAgeClass[] getNonSelectable() {
	return CascoCarAgeClass.nonSelectableValues();
    }
}
