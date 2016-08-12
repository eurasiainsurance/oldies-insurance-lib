package com.lapsa.insurance.elements;

import com.lapsa.insurance.ElementsBundleBase;

public enum CascoDeductiblePartialRate implements ElementsBundleBase {
    PERCENT0_5(.005d), // 0.5%
    PERCENT1(.010d), // 1%
    PERCENT2(.020d), // 2%
    PERCENT3(.030d), // 3%
    PERCENT5(.050d), // 5%
    PERCENT10(.100d), // 10%
    ;

    private final double value;

    @Override
    public String canonicalName() {
	return String.format("%1$s.%2$s", this.getClass().getName(), name());
    }

    private CascoDeductiblePartialRate(double value) {
	this.value = value;
    }

    public double getValue() {
	return value;
    }
}
