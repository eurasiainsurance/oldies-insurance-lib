package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

import com.lapsa.commons.elements.LocalizedElement;

public enum CascoDeductibleFullRate implements LocalizedElement {
    PERCENT5(.05d), // 5%
    PERCENT10(.10d), // 10%
    ;

    //

    private final boolean selectable;
    private final double value;

    //

    private CascoDeductibleFullRate(double value) {
	this.selectable = true;
	this.value = value;
    }

    private CascoDeductibleFullRate(double value, boolean selectable) {
	this.selectable = selectable;
	this.value = value;
    }

    //

    public static final Stream<CascoDeductibleFullRate> valuesStream() {
	return Stream.of(values());
    }

    //

    private static final Predicate<CascoDeductibleFullRate> SELECTABLE_FILTER = CascoDeductibleFullRate::isSelectable;

    public static final CascoDeductibleFullRate[] selectableValues() {
	return valuesStream() //
		.filter(SELECTABLE_FILTER) //
		.toArray(CascoDeductibleFullRate[]::new);
    }

    private static final Predicate<CascoDeductibleFullRate> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final CascoDeductibleFullRate[] nonSelectableValues() {
	return valuesStream() //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(CascoDeductibleFullRate[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }

    public double getValue() {
	return value;
    }
}
