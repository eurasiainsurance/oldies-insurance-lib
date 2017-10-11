package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

import tech.lapsa.java.commons.localization.LocalizedElement;

public enum Sex implements LocalizedElement {
    MALE, // мужской
    FEMALE, // женский
    ;

    //

    private final boolean selectable;

    //

    private Sex() {
	this.selectable = true;
    }

    private Sex(boolean selectable) {
	this.selectable = selectable;
    }

    //

    public static final Stream<Sex> valuesStream() {
	return Stream.of(values());
    }

    //

    private static final Predicate<Sex> SELECTABLE_FILTER = Sex::isSelectable;

    public static final Sex[] selectableValues() {
	return valuesStream() //
		.filter(SELECTABLE_FILTER) //
		.toArray(Sex[]::new);
    }

    private static final Predicate<Sex> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final Sex[] nonSelectableValues() {
	return valuesStream() //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(Sex[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }
}
