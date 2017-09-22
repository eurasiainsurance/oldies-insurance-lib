package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

public enum PaymentStatus implements InsuranceLocalizedElement {
    PENDING, // ожидается оплата
    DONE, // оплачено
    CANCELED, // отменено
    UNDEFINED(false), // не определно
    ;

    //

    private final boolean selectable;

    //

    private PaymentStatus() {
	this.selectable = true;
    }

    private PaymentStatus(boolean selectable) {
	this.selectable = selectable;
    }

    //
    
    private static final Predicate<PaymentStatus> SELECTABLE_FILTER = PaymentStatus::isSelectable;

    public static final PaymentStatus[] selectableValues() {
	return Stream.of(values()) //
		.filter(SELECTABLE_FILTER) //
		.toArray(PaymentStatus[]::new);
    }

    private static final Predicate<PaymentStatus> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final PaymentStatus[] nonSelectableValues() {
	return Stream.of(values()) //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(PaymentStatus[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }
}
