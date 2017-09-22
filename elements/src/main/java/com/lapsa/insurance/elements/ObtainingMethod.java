package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

public enum ObtainingMethod implements InsuranceLocalizedElement {
    DELIVERY, // доставить курьером
    PICKUP, // забрать самостоятельно в офисе компании
    UNDEFINED(false), // не определен
    ;

    //

    private final boolean selectable;

    //

    private ObtainingMethod() {
	this.selectable = true;
    }

    private ObtainingMethod(boolean selectable) {
	this.selectable = selectable;
    }

    //

    private static final Predicate<ObtainingMethod> SELECTABLE_FILTER = ObtainingMethod::isSelectable;

    public static final ObtainingMethod[] selectableValues() {
	return Stream.of(values()) //
		.filter(SELECTABLE_FILTER) //
		.toArray(ObtainingMethod[]::new);
    }

    private static final Predicate<ObtainingMethod> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final ObtainingMethod[] nonSelectableValues() {
	return Stream.of(values()) //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(ObtainingMethod[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }
}
