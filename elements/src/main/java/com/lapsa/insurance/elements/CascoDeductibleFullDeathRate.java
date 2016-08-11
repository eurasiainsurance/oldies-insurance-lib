package com.lapsa.insurance.elements;

import com.lapsa.insurance.ElementsBundleBase;

public enum CascoDeductibleFullDeathRate implements ElementsBundleBase {
    PERCENT5(.05d), // 5%
    PERCENT10(.10d), // 10%
    ;

    private final double value;

    @Override
    public String canonicalName() {
	return String.format("%1$s.%2$s", this.getClass().getName(), name());
    }

    private CascoDeductibleFullDeathRate(double value) {
	this.value = value;
    }

    public double getValue() {
	return value;
    }

}
