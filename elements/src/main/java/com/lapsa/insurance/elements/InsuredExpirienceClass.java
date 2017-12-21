package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

import tech.lapsa.java.commons.localization.LocalizedElement;

public enum InsuredExpirienceClass implements LocalizedElement {
    MORE2, // стаж вождения более 2 лет
    LESS2, // стаж вождения менее 2 лет
    ;

    //

    private final boolean selectable;

    //

    private InsuredExpirienceClass() {
	selectable = true;
    }

    private InsuredExpirienceClass(final boolean selectable) {
	this.selectable = selectable;
    }

    //

    public static final Stream<InsuredExpirienceClass> valuesStream() {
	return Stream.of(values());
    }

    //

    private static final Predicate<InsuredExpirienceClass> SELECTABLE_FILTER = InsuredExpirienceClass::isSelectable;

    public static final InsuredExpirienceClass[] selectableValues() {
	return valuesStream() //
		.filter(SELECTABLE_FILTER) //
		.toArray(InsuredExpirienceClass[]::new);
    }

    private static final Predicate<InsuredExpirienceClass> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final InsuredExpirienceClass[] nonSelectableValues() {
	return valuesStream() //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(InsuredExpirienceClass[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }
}
