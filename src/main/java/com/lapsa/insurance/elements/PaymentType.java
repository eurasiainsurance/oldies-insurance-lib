package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

import tech.lapsa.java.commons.localization.LocalizedElement;

public enum PaymentType implements LocalizedElement {
    IMMEDIATELY, // Единовременно
    BY_INSTALLMENTS, // В рассрочку
    ;

    //

    private final boolean selectable;

    //

    private PaymentType() {
	selectable = true;
    }

    private PaymentType(final boolean selectable) {
	this.selectable = selectable;
    }

    //

    public static final Stream<PaymentType> valuesStream() {
	return Stream.of(values());
    }

    //

    private static final Predicate<PaymentType> SELECTABLE_FILTER = PaymentType::isSelectable;

    public static final PaymentType[] selectableValues() {
	return valuesStream() //
		.filter(SELECTABLE_FILTER) //
		.toArray(PaymentType[]::new);
    }

    private static final Predicate<PaymentType> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final PaymentType[] nonSelectableValues() {
	return valuesStream() //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(PaymentType[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }
}
