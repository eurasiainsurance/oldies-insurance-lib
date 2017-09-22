package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

public enum VehicleAgeClass implements InsuranceLocalizedElement {
    UNDER7, // До 7 лет включительно
    OVER7, // Свыше 7 лет
    ;

    //

    private final boolean selectable;

    //

    private VehicleAgeClass() {
	this.selectable = true;
    }

    private VehicleAgeClass(boolean selectable) {
	this.selectable = selectable;
    }

    //

    private static final Predicate<VehicleAgeClass> SELECTABLE_FILTER = VehicleAgeClass::isSelectable;

    public static final VehicleAgeClass[] selectableValues() {
	return Stream.of(values()) //
		.filter(SELECTABLE_FILTER) //
		.toArray(VehicleAgeClass[]::new);
    }

    private static final Predicate<VehicleAgeClass> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final VehicleAgeClass[] nonSelectableValues() {
	return Stream.of(values()) //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(VehicleAgeClass[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }
}
