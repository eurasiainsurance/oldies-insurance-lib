package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

import tech.lapsa.java.commons.localization.LocalizedElement;

public enum RequestCancelationReason implements LocalizedElement {
    CANCELED_BY_CONSUMER, //
    WRONG_DATA_PROVIDED, //
    TEST, //
    DUPLICATE,
    OTHER, //
    ;

    //

    private final boolean selectable;

    //

    private RequestCancelationReason() {
	selectable = true;
    }

    private RequestCancelationReason(final boolean selectable) {
	this.selectable = selectable;
    }

    //

    public static final Stream<RequestCancelationReason> valuesStream() {
	return Stream.of(values());
    }

    //

    private static final Predicate<RequestCancelationReason> SELECTABLE_FILTER = RequestCancelationReason::isSelectable;

    public static final RequestCancelationReason[] selectableValues() {
	return valuesStream() //
		.filter(SELECTABLE_FILTER) //
		.toArray(RequestCancelationReason[]::new);
    }

    private static final Predicate<RequestCancelationReason> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final RequestCancelationReason[] nonSelectableValues() {
	return valuesStream() //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(RequestCancelationReason[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }
}
