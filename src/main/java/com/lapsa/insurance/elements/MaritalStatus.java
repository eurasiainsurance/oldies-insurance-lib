package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

import tech.lapsa.java.commons.localization.LocalizedElement;

public enum MaritalStatus implements LocalizedElement {
    MARRIED, // женат / замужем
    SINGLE, // холост / незамужем
    ;

    //

    private final boolean selectable;

    //

    private MaritalStatus() {
	selectable = true;
    }

    private MaritalStatus(final boolean selectable) {
	this.selectable = selectable;
    }

    //

    public static final Stream<MaritalStatus> valuesStream() {
	return Stream.of(values());
    }

    //

    private static final Predicate<MaritalStatus> SELECTABLE_FILTER = MaritalStatus::isSelectable;

    public static final MaritalStatus[] selectableValues() {
	return valuesStream() //
		.filter(SELECTABLE_FILTER) //
		.toArray(MaritalStatus[]::new);
    }

    private static final Predicate<MaritalStatus> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final MaritalStatus[] nonSelectableValues() {
	return valuesStream() //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(MaritalStatus[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }
}
