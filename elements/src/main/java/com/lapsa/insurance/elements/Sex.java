package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

public enum Sex implements InsuranceLocalizedElement {
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

    private static final Predicate<Sex> SELECTABLE_FILTER = Sex::isSelectable;

    public static final Sex[] selectableValues() {
	return Stream.of(values()) //
		.filter(SELECTABLE_FILTER) //
		.toArray(Sex[]::new);
    }

    private static final Predicate<Sex> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final Sex[] nonSelectableValues() {
	return Stream.of(values()) //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(Sex[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }
}
