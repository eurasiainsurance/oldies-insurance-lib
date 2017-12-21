package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

import tech.lapsa.java.commons.localization.LocalizedElement;

public enum RequestSource implements LocalizedElement {
    API, //
    INTERNAL, //
    ;

    //

    private final boolean selectable;

    //

    private RequestSource() {
	selectable = true;
    }

    private RequestSource(final boolean selectable) {
	this.selectable = selectable;
    }

    //

    public static final Stream<RequestSource> valuesStream() {
	return Stream.of(values());
    }

    //

    private static final Predicate<RequestSource> SELECTABLE_FILTER = RequestSource::isSelectable;

    public static final RequestSource[] selectableValues() {
	return valuesStream() //
		.filter(SELECTABLE_FILTER) //
		.toArray(RequestSource[]::new);
    }

    private static final Predicate<RequestSource> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final RequestSource[] nonSelectableValues() {
	return valuesStream() //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(RequestSource[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }
}
