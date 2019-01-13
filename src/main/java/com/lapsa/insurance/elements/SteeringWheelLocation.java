package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

import tech.lapsa.java.commons.localization.LocalizedElement;

public enum SteeringWheelLocation implements LocalizedElement {
    RIGHT_SIDE, // руль справа
    LEFT_SIDE, // руль слева
    ;

    //

    private final boolean selectable;

    //

    private SteeringWheelLocation() {
	selectable = true;
    }

    private SteeringWheelLocation(final boolean selectable) {
	this.selectable = selectable;
    }

    //

    public static final Stream<SteeringWheelLocation> valuesStream() {
	return Stream.of(values());
    }

    //

    private static final Predicate<SteeringWheelLocation> SELECTABLE_FILTER = SteeringWheelLocation::isSelectable;

    public static final SteeringWheelLocation[] selectableValues() {
	return valuesStream() //
		.filter(SELECTABLE_FILTER) //
		.toArray(SteeringWheelLocation[]::new);
    }

    private static final Predicate<SteeringWheelLocation> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final SteeringWheelLocation[] nonSelectableValues() {
	return valuesStream() //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(SteeringWheelLocation[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }
}
