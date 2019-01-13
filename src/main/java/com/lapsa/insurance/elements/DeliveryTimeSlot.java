package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

import tech.lapsa.java.commons.localization.LocalizedElement;

public enum DeliveryTimeSlot implements LocalizedElement {
    DURING_THE_DAY, // в течении дня
    BEFORE_LUNCH, // в первой половине дня (с 9:00 до 13:00)
    AFTER_LUNCH, // во второй половине дня (с 13:00 до 18:00)
    EVENING, // вечером (с 18:00 до 21:00)
    ;

    //

    private final boolean selectable;

    //

    private DeliveryTimeSlot() {
	selectable = true;
    }

    private DeliveryTimeSlot(final boolean selectable) {
	this.selectable = selectable;
    }

    //

    public static final Stream<DeliveryTimeSlot> valuesStream() {
	return Stream.of(values());
    }

    //

    private static final Predicate<DeliveryTimeSlot> SELECTABLE_FILTER = DeliveryTimeSlot::isSelectable;

    public static final DeliveryTimeSlot[] selectableValues() {
	return valuesStream() //
		.filter(SELECTABLE_FILTER) //
		.toArray(DeliveryTimeSlot[]::new);
    }

    private static final Predicate<DeliveryTimeSlot> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final DeliveryTimeSlot[] nonSelectableValues() {
	return valuesStream() //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(DeliveryTimeSlot[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }
}
