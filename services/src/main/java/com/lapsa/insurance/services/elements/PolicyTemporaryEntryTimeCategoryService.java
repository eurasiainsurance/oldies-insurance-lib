package com.lapsa.insurance.services.elements;

import com.lapsa.commons.elements.NamingListingService;
import com.lapsa.insurance.elements.PolicyTemporaryEntryTimeCategory;

public interface PolicyTemporaryEntryTimeCategoryService
	extends NamingListingService<PolicyTemporaryEntryTimeCategory> {

    @Override
    default PolicyTemporaryEntryTimeCategory[] getAll() {
	return PolicyTemporaryEntryTimeCategory.values();
    }

    @Override
    default PolicyTemporaryEntryTimeCategory[] getSelectable() {
	return PolicyTemporaryEntryTimeCategory.selectableValues();
    }

    @Override
    default PolicyTemporaryEntryTimeCategory[] getNonSelectable() {
	return PolicyTemporaryEntryTimeCategory.nonSelectableValues();
    }
}
