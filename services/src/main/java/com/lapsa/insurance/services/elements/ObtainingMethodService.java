package com.lapsa.insurance.services.elements;

import com.lapsa.commons.elements.NamingListingService;
import com.lapsa.insurance.elements.ObtainingMethod;

public interface ObtainingMethodService extends NamingListingService<ObtainingMethod> {

    @Override
    default ObtainingMethod[] getAll() {
	return ObtainingMethod.values();
    }

    @Override
    default ObtainingMethod[] getSelectable() {
	return ObtainingMethod.selectableValues();
    }

    @Override
    default ObtainingMethod[] getNonSelectable() {
	return ObtainingMethod.nonSelectableValues();
    }
}
