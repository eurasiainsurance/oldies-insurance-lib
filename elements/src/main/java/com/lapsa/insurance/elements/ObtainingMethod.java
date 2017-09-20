package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

public enum ObtainingMethod implements InsuranceLocalizedElement {
    DELIVERY, // доставить курьером
    PICKUP, // забрать самостоятельно в офисе компании
    UNDEFINED, // не определен
    //
    ;

    private static final Predicate<ObtainingMethod> SELECTABLE_FILTER = x -> ObtainingMethod.UNDEFINED != x;
    private static final Predicate<ObtainingMethod> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final ObtainingMethod[] selectableValues() {
	return Stream.of(values()).filter(SELECTABLE_FILTER).toArray(ObtainingMethod[]::new);
    }

    public static final ObtainingMethod[] nonSelectableValues() {
	return Stream.of(values()).filter(NON_SELECTABLE_FILTER).toArray(ObtainingMethod[]::new);
    }
}
