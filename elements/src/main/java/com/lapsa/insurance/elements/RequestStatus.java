package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

public enum RequestStatus implements InsuranceLocalizedElement {
    OPEN, // Открыто
    CLOSED, // Закрыто
    ;

    //

    private final boolean selectable;

    //

    private RequestStatus() {
	this.selectable = true;
    }

    private RequestStatus(boolean selectable) {
	this.selectable = selectable;
    }

    //

    private static final Predicate<RequestStatus> SELECTABLE_FILTER = RequestStatus::isSelectable;

    public static final RequestStatus[] selectableValues() {
	return Stream.of(values()) //
		.filter(SELECTABLE_FILTER) //
		.toArray(RequestStatus[]::new);
    }

    private static final Predicate<RequestStatus> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final RequestStatus[] nonSelectableValues() {
	return Stream.of(values()) //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(RequestStatus[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }
}
