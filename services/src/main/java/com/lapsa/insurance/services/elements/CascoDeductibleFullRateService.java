package com.lapsa.insurance.services.elements;

import com.lapsa.commons.elements.NamingListingService;
import com.lapsa.insurance.elements.CascoDeductibleFullRate;

public interface CascoDeductibleFullRateService extends NamingListingService<CascoDeductibleFullRate> {

    @Override
    default CascoDeductibleFullRate[] getAll() {
	return CascoDeductibleFullRate.values();
    }

    @Override
    default CascoDeductibleFullRate[] getSelectable() {
	return CascoDeductibleFullRate.selectableValues();
    }

    @Override
    default CascoDeductibleFullRate[] getNonSelectable() {
	return CascoDeductibleFullRate.nonSelectableValues();
    }
}
