package com.lapsa.insurance.elements;

import com.lapsa.insurance.ElementsBundleBase;

public enum CascoDeductiblePartialDamageRate implements ElementsBundleBase {
    ZERO, // 0%
    PERCENT0_5, // 0.5%
    PERCENT1, // 1%
    PERCENT2, // 2%
    PERCENT3, // 3%
    PERCENT5, // 5%
    PERCENT10, // 10%
    ;

    @Override
    public String canonicalName() {
	return String.format("%1$s.%2$s", this.getClass().getName(), name());
    }
}
