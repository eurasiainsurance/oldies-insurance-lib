package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

import tech.lapsa.java.commons.localization.LocalizedElement;

public enum InsuranceRequestCancellationReason implements LocalizedElement {
    CANCELED_BY_CONSUMER, //
    WRONG_DATA_PROVIDED, //
    TEST, //
    DUPLICATE,
    OTHER, //
    ;

    //

    private final boolean selectable;

    //

    private InsuranceRequestCancellationReason() {
	selectable = true;
    }

    private InsuranceRequestCancellationReason(final boolean selectable) {
	this.selectable = selectable;
    }

    //

    public static final Stream<InsuranceRequestCancellationReason> valuesStream() {
	return Stream.of(values());
    }

    //

    private static final Predicate<InsuranceRequestCancellationReason> SELECTABLE_FILTER = InsuranceRequestCancellationReason::isSelectable;

    public static final InsuranceRequestCancellationReason[] selectableValues() {
	return valuesStream() //
		.filter(SELECTABLE_FILTER) //
		.toArray(InsuranceRequestCancellationReason[]::new);
    }

    private static final Predicate<InsuranceRequestCancellationReason> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final InsuranceRequestCancellationReason[] nonSelectableValues() {
	return valuesStream() //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(InsuranceRequestCancellationReason[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }
}
