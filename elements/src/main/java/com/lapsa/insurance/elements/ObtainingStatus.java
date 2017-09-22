package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

public enum ObtainingStatus implements InsuranceLocalizedElement {
    PENDING, // ожидается получение
    DONE, // получено
    CANCELED, // отменено
    UNDEFINED(false), // не определно
    ;

    //

    private final boolean selectable;

    //

    private ObtainingStatus() {
	this.selectable = true;
    }

    private ObtainingStatus(boolean selectable) {
	this.selectable = selectable;
    }

    //

    private static final Predicate<ObtainingStatus> SELECTABLE_FILTER = ObtainingStatus::isSelectable;

    public static final ObtainingStatus[] selectableValues() {
	return Stream.of(values()) //
		.filter(SELECTABLE_FILTER) //
		.toArray(ObtainingStatus[]::new);
    }

    private static final Predicate<ObtainingStatus> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final ObtainingStatus[] nonSelectableValues() {
	return Stream.of(values()) //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(ObtainingStatus[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }
}