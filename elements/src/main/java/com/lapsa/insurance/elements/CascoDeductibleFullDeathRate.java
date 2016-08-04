package com.lapsa.insurance.elements;

import com.lapsa.insurance.ElementsBundleBase;

public enum CascoDeductibleFullDeathRate implements ElementsBundleBase {
    PERCENT5, // 5%
    PERCENT10, // 10%
    ;

    @Override
    public String canonicalName() {
	return String.format("%1$s.%2$s", this.getClass().getName(), name());
    }
}
