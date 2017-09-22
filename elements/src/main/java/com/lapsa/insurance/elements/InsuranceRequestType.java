package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

public enum InsuranceRequestType implements InsuranceLocalizedElement {
    EXPRESS, // экспресс
    ONLINE, // он-лайн
    UNCOMPLETE, // лид
    ;

    //

    private final boolean selectable;

    //

    private InsuranceRequestType() {
	this.selectable = true;
    }

    private InsuranceRequestType(boolean selectable) {
	this.selectable = selectable;
    }

    //

    private static final Predicate<InsuranceRequestType> SELECTABLE_FILTER = InsuranceRequestType::isSelectable;

    public static final InsuranceRequestType[] selectableValues() {
	return Stream.of(values()) //
		.filter(SELECTABLE_FILTER) //
		.toArray(InsuranceRequestType[]::new);
    }

    private static final Predicate<InsuranceRequestType> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final InsuranceRequestType[] nonSelectableValues() {
	return Stream.of(values()) //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(InsuranceRequestType[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }
}
