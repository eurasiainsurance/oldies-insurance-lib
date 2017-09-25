package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

import com.lapsa.commons.elements.LocalizedElement;

public enum InsuranceClassType implements LocalizedElement {
    CLASS_0, //
    CLASS_1, //
    CLASS_2, //
    CLASS_3, //
    CLASS_4, //
    CLASS_5, //
    CLASS_6, //
    CLASS_7, //
    CLASS_8, //
    CLASS_9, //
    CLASS_10, //
    CLASS_11, //
    CLASS_12, //
    CLASS_13, //
    CLASS_M, //
    ;

    //

    private final boolean selectable;

    //

    private InsuranceClassType() {
	this.selectable = true;
    }

    private InsuranceClassType(boolean selectable) {
	this.selectable = selectable;
    }

    //

    public static final Stream<InsuranceClassType> valuesStream() {
	return Stream.of(values());
    }

    //

    private static final Predicate<InsuranceClassType> SELECTABLE_FILTER = InsuranceClassType::isSelectable;

    public static final InsuranceClassType[] selectableValues() {
	return valuesStream() //
		.filter(SELECTABLE_FILTER) //
		.toArray(InsuranceClassType[]::new);
    }

    private static final Predicate<InsuranceClassType> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final InsuranceClassType[] nonSelectableValues() {
	return valuesStream() //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(InsuranceClassType[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }
}