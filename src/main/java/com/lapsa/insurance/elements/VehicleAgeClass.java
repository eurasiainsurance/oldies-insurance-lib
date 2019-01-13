package com.lapsa.insurance.elements;

import java.time.LocalDate;
import java.util.function.Predicate;
import java.util.stream.Stream;

import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.java.commons.localization.LocalizedElement;

public enum VehicleAgeClass implements LocalizedElement {
    UNDER7, // До 7 лет включительно
    OVER7, // Свыше 7 лет
    ;

    //

    private final boolean selectable;

    //

    private VehicleAgeClass() {
	selectable = true;
    }

    private VehicleAgeClass(final boolean selectable) {
	this.selectable = selectable;
    }

    //

    public static final Stream<VehicleAgeClass> valuesStream() {
	return Stream.of(values());
    }

    //

    private static final Predicate<VehicleAgeClass> SELECTABLE_FILTER = VehicleAgeClass::isSelectable;

    public static final VehicleAgeClass[] selectableValues() {
	return valuesStream() //
		.filter(SELECTABLE_FILTER) //
		.toArray(VehicleAgeClass[]::new);
    }

    private static final Predicate<VehicleAgeClass> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final VehicleAgeClass[] nonSelectableValues() {
	return valuesStream() //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(VehicleAgeClass[]::new);
    }

    public static VehicleAgeClass forYearOfManufacture(final int year) {
	final int age = LocalDate.now().getYear() - year;
	return (age <= 7)
		? UNDER7
		: OVER7;
    }

    public static VehicleAgeClass forDateOfManufacture(final LocalDate date) throws IllegalArgumentException {
	return forYearOfManufacture(MyObjects.requireNonNull(date, "date").getYear());
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }
}
