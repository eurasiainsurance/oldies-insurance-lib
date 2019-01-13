package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

import tech.lapsa.java.commons.localization.LocalizedElement;

public enum InsuranceRequestType implements LocalizedElement {
    EXPRESS, // экспресс
    ONLINE, // он-лайн
    UNCOMPLETE, // лид
    ;

    //

    private final boolean selectable;

    //

    private InsuranceRequestType() {
	selectable = true;
    }

    private InsuranceRequestType(final boolean selectable) {
	this.selectable = selectable;
    }

    //

    public static final Stream<InsuranceRequestType> valuesStream() {
	return Stream.of(values());
    }

    //

    private static final Predicate<InsuranceRequestType> SELECTABLE_FILTER = InsuranceRequestType::isSelectable;

    public static final InsuranceRequestType[] selectableValues() {
	return valuesStream() //
		.filter(SELECTABLE_FILTER) //
		.toArray(InsuranceRequestType[]::new);
    }

    private static final Predicate<InsuranceRequestType> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final InsuranceRequestType[] nonSelectableValues() {
	return valuesStream() //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(InsuranceRequestType[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }
}
