package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

public enum InsuredExpirienceClass implements InsuranceLocalizedElement {
    MORE2, // стаж вождения более 2 лет
    LESS2, // стаж вождения менее 2 лет
    ;

    //

    private final boolean selectable;

    //

    private InsuredExpirienceClass() {
	this.selectable = true;
    }

    private InsuredExpirienceClass(boolean selectable) {
	this.selectable = selectable;
    }

    //

    private static final Predicate<InsuredExpirienceClass> SELECTABLE_FILTER = InsuredExpirienceClass::isSelectable;

    public static final InsuredExpirienceClass[] selectableValues() {
	return Stream.of(values()) //
		.filter(SELECTABLE_FILTER) //
		.toArray(InsuredExpirienceClass[]::new);
    }

    private static final Predicate<InsuredExpirienceClass> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final InsuredExpirienceClass[] nonSelectableValues() {
	return Stream.of(values()) //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(InsuredExpirienceClass[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }
}
