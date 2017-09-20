package com.lapsa.insurance.elements;

public enum CascoDeductiblePartialRate implements LocalizedElement {
    PERCENT0_5(.005d), // 0.5%
    PERCENT1(.010d), // 1%
    PERCENT2(.020d), // 2%
    PERCENT3(.030d), // 3%
    PERCENT5(.050d), // 5%
    PERCENT10(.100d), // 10%
    ;

    private final double value;

    private CascoDeductiblePartialRate(double value) {
	this.value = value;
    }

    public double getValue() {
	return value;
    }
}
