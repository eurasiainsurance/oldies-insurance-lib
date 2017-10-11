package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

import tech.lapsa.java.commons.localization.LocalizedElement;

public enum CascoDeductiblePartialRate implements LocalizedElement {
    PERCENT0_5(.005d), // 0.5%
    PERCENT1(.010d), // 1%
    PERCENT2(.020d), // 2%
    PERCENT3(.030d), // 3%
    PERCENT5(.050d), // 5%
    PERCENT10(.100d), // 10%
    ;

    //

    private final boolean selectable;
    private final double value;

    //

    private CascoDeductiblePartialRate(double value) {
	this.selectable = true;
	this.value = value;
    }

    private CascoDeductiblePartialRate(double value, boolean selectable) {
	this.selectable = selectable;
	this.value = value;
    }

    //

    public static final Stream<CascoDeductiblePartialRate> valuesStream() {
	return Stream.of(values());
    }

    //

    private static final Predicate<CascoDeductiblePartialRate> SELECTABLE_FILTER = CascoDeductiblePartialRate::isSelectable;

    public static final CascoDeductiblePartialRate[] selectableValues() {
	return valuesStream() //
		.filter(SELECTABLE_FILTER) //
		.toArray(CascoDeductiblePartialRate[]::new);
    }

    private static final Predicate<CascoDeductiblePartialRate> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final CascoDeductiblePartialRate[] nonSelectableValues() {
	return valuesStream() //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(CascoDeductiblePartialRate[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }

    public double getValue() {
	return value;
    }
}
