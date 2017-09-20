package com.lapsa.insurance.elements;

public enum CascoDeductibleFullRate implements InsuranceLocalizedElement {
    PERCENT5(.05d), // 5%
    PERCENT10(.10d), // 10%
    ;

    private final double value;

    private CascoDeductibleFullRate(double value) {
	this.value = value;
    }

    public double getValue() {
	return value;
    }

}
