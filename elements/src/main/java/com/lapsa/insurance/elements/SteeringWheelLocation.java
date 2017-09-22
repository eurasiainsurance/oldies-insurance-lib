package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

public enum SteeringWheelLocation implements InsuranceLocalizedElement {
    RIGHT_SIDE, // руль справа
    LEFT_SIDE, // руль слева
    ;

    //

    private final boolean selectable;

    //

    private SteeringWheelLocation() {
	this.selectable = true;
    }

    private SteeringWheelLocation(boolean selectable) {
	this.selectable = selectable;
    }

    //

    private static final Predicate<SteeringWheelLocation> SELECTABLE_FILTER = SteeringWheelLocation::isSelectable;

    public static final SteeringWheelLocation[] selectableValues() {
	return Stream.of(values()) //
		.filter(SELECTABLE_FILTER) //
		.toArray(SteeringWheelLocation[]::new);
    }

    private static final Predicate<SteeringWheelLocation> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final SteeringWheelLocation[] nonSelectableValues() {
	return Stream.of(values()) //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(SteeringWheelLocation[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }
}
