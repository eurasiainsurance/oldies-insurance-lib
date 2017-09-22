package com.lapsa.insurance.services.elements;

import com.lapsa.commons.elements.NamingListingService;
import com.lapsa.insurance.elements.SubjectType;

public interface SubjectTypeService extends NamingListingService<SubjectType> {

    @Override
    default SubjectType[] getAll() {
	return SubjectType.values();
    }

    @Override
    default SubjectType[] getSelectable() {
	return SubjectType.selectableValues();
    }

    @Override
    default SubjectType[] getNonSelectable() {
	return SubjectType.nonSelectableValues();
    }
}
