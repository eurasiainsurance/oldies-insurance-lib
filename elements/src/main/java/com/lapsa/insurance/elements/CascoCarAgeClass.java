package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

import tech.lapsa.java.commons.localization.LocalizedElement;

public enum CascoCarAgeClass implements LocalizedElement {
    UNDER3, // до 3 лет
    FROM3TO7, // от 3 до 7 лет
    OTHER7, // старше 7 лет
    ;

    //

    private final boolean selectable;

    //

    private CascoCarAgeClass() {
	selectable = true;
    }

    private CascoCarAgeClass(final boolean selectable) {
	this.selectable = selectable;
    }

    //

    public static final Stream<CascoCarAgeClass> valuesStream() {
	return Stream.of(values());
    }

    //

    private static final Predicate<CascoCarAgeClass> SELECTABLE_FILTER = CascoCarAgeClass::isSelectable;

    public static final CascoCarAgeClass[] selectableValues() {
	return valuesStream() //
		.filter(SELECTABLE_FILTER) //
		.toArray(CascoCarAgeClass[]::new);
    }

    private static final Predicate<CascoCarAgeClass> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final CascoCarAgeClass[] nonSelectableValues() {
	return valuesStream() //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(CascoCarAgeClass[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }
}
