package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

public enum ObtainingStatus implements LocalizedElement {
    PENDING, // ожидается получение
    DONE, // получено
    CANCELED, // отменено
    UNDEFINED, // не определно
    //
    ;

    private static final Predicate<ObtainingStatus> SELECTABLE_FILTER = x -> ObtainingStatus.UNDEFINED != x;
    private static final Predicate<ObtainingStatus> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final ObtainingStatus[] selectableValues() {
	return Stream.of(values()).filter(SELECTABLE_FILTER).toArray(ObtainingStatus[]::new);
    }

    public static final ObtainingStatus[] nonSelectableValues() {
	return Stream.of(values()).filter(NON_SELECTABLE_FILTER).toArray(ObtainingStatus[]::new);
    }
}