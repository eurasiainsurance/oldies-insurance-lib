package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

public enum InsuranceClassType implements InsuranceLocalizedElement {
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

    private static final Predicate<InsuranceClassType> SELECTABLE_FILTER = InsuranceClassType::isSelectable;

    public static final InsuranceClassType[] selectableValues() {
	return Stream.of(values()) //
		.filter(SELECTABLE_FILTER) //
		.toArray(InsuranceClassType[]::new);
    }

    private static final Predicate<InsuranceClassType> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final InsuranceClassType[] nonSelectableValues() {
	return Stream.of(values()) //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(InsuranceClassType[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }
}