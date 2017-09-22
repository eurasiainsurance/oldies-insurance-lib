package com.lapsa.insurance.services.elements;

import com.lapsa.commons.elements.NamingListingService;
import com.lapsa.insurance.elements.CascoDeductiblePartialRate;

public interface CascoDeductiblePartialRateService extends NamingListingService<CascoDeductiblePartialRate> {

    @Override
    default CascoDeductiblePartialRate[] getAll() {
	return CascoDeductiblePartialRate.values();
    }

    @Override
    default CascoDeductiblePartialRate[] getSelectable() {
	return CascoDeductiblePartialRate.selectableValues();
    }

    @Override
    default CascoDeductiblePartialRate[] getNonSelectable() {
	return CascoDeductiblePartialRate.nonSelectableValues();
    }
}
