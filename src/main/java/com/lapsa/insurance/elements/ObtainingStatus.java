package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

import tech.lapsa.java.commons.localization.LocalizedElement;

public enum ObtainingStatus implements LocalizedElement {
    PENDING, // ожидается получение
    DONE, // получено
    CANCELED, // отменено
    UNDEFINED(false), // не определно
    ;

    //

    private final boolean defined;

    //

    private ObtainingStatus() {
	defined = true;
    }

    private ObtainingStatus(final boolean selectable) {
	defined = selectable;
    }

    //

    public static final Stream<ObtainingStatus> valuesStream() {
	return Stream.of(values());
    }

    //

    private static final Predicate<ObtainingStatus> SELECTABLE_FILTER = ObtainingStatus::isSelectable;

    public static final ObtainingStatus[] selectableValues() {
	return valuesStream() //
		.filter(SELECTABLE_FILTER) //
		.toArray(ObtainingStatus[]::new);
    }

    private static final Predicate<ObtainingStatus> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final ObtainingStatus[] nonSelectableValues() {
	return valuesStream() //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(ObtainingStatus[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return defined;
    }

    public boolean isDefined() {
	return defined;
    }
}