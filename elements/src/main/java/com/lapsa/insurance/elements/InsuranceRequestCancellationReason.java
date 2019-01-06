package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

import tech.lapsa.java.commons.localization.LocalizedElement;

public enum InsuranceRequestCancelationReason implements LocalizedElement {
    CANCELED_BY_CONSUMER, //
    WRONG_DATA_PROVIDED, //
    TEST, //
    DUPLICATE,
    OTHER, //
    ;

    //

    private final boolean selectable;

    //

    private InsuranceRequestCancelationReason() {
	selectable = true;
    }

    private InsuranceRequestCancelationReason(final boolean selectable) {
	this.selectable = selectable;
    }

    //

    public static final Stream<InsuranceRequestCancelationReason> valuesStream() {
	return Stream.of(values());
    }

    //

    private static final Predicate<InsuranceRequestCancelationReason> SELECTABLE_FILTER = InsuranceRequestCancelationReason::isSelectable;

    public static final InsuranceRequestCancelationReason[] selectableValues() {
	return valuesStream() //
		.filter(SELECTABLE_FILTER) //
		.toArray(InsuranceRequestCancelationReason[]::new);
    }

    private static final Predicate<InsuranceRequestCancelationReason> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final InsuranceRequestCancelationReason[] nonSelectableValues() {
	return valuesStream() //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(InsuranceRequestCancelationReason[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }
}
