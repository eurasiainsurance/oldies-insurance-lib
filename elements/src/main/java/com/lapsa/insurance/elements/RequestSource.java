package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

public enum RequestSource implements InsuranceLocalizedElement {
    API, //
    INTERNAL, //
    ;

    //

    private final boolean selectable;

    //

    private RequestSource() {
	this.selectable = true;
    }

    private RequestSource(boolean selectable) {
	this.selectable = selectable;
    }

    //

    private static final Predicate<RequestSource> SELECTABLE_FILTER = RequestSource::isSelectable;

    public static final RequestSource[] selectableValues() {
	return Stream.of(values()) //
		.filter(SELECTABLE_FILTER) //
		.toArray(RequestSource[]::new);
    }

    private static final Predicate<RequestSource> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final RequestSource[] nonSelectableValues() {
	return Stream.of(values()) //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(RequestSource[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }
}
