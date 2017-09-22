package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

public enum MaritalStatus implements InsuranceLocalizedElement {
    MARRIED, // женат / замужем
    SINGLE, // холост / незамужем
    ;

    //

    private final boolean selectable;

    //

    private MaritalStatus() {
	this.selectable = true;
    }

    private MaritalStatus(boolean selectable) {
	this.selectable = selectable;
    }

    //

    private static final Predicate<MaritalStatus> SELECTABLE_FILTER = MaritalStatus::isSelectable;

    public static final MaritalStatus[] selectableValues() {
	return Stream.of(values()) //
		.filter(SELECTABLE_FILTER) //
		.toArray(MaritalStatus[]::new);
    }

    private static final Predicate<MaritalStatus> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final MaritalStatus[] nonSelectableValues() {
	return Stream.of(values()) //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(MaritalStatus[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }
}
