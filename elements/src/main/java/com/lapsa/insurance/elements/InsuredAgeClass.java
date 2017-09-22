package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

public enum InsuredAgeClass implements InsuranceLocalizedElement {
    OVER25, // возраст старше 25 лет
    UNDER25, // возраст моложе 25 лет
    ;

    //

    private final boolean selectable;

    //

    private InsuredAgeClass() {
	this.selectable = true;
    }

    private InsuredAgeClass(boolean selectable) {
	this.selectable = selectable;
    }

    //

    private static final Predicate<InsuredAgeClass> SELECTABLE_FILTER = InsuredAgeClass::isSelectable;

    public static final InsuredAgeClass[] selectableValues() {
	return Stream.of(values()) //
		.filter(SELECTABLE_FILTER) //
		.toArray(InsuredAgeClass[]::new);
    }

    private static final Predicate<InsuredAgeClass> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final InsuredAgeClass[] nonSelectableValues() {
	return Stream.of(values()) //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(InsuredAgeClass[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }
}
