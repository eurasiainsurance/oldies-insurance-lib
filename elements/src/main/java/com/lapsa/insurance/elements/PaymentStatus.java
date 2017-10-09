package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

import com.lapsa.commons.elements.LocalizedElement;

public enum PaymentStatus implements LocalizedElement {
    PENDING, // ожидается оплата
    DONE, // оплачено
    CANCELED, // отменено
    UNDEFINED(false), // не определно
    ;

    //

    private final boolean defined;

    //

    private PaymentStatus() {
	this.defined = true;
    }

    private PaymentStatus(boolean selectable) {
	this.defined = selectable;
    }

    //

    public static final Stream<PaymentStatus> valuesStream() {
	return Stream.of(values());
    }

    //

    private static final Predicate<PaymentStatus> SELECTABLE_FILTER = PaymentStatus::isSelectable;

    public static final PaymentStatus[] selectableValues() {
	return valuesStream() //
		.filter(SELECTABLE_FILTER) //
		.toArray(PaymentStatus[]::new);
    }

    private static final Predicate<PaymentStatus> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final PaymentStatus[] nonSelectableValues() {
	return valuesStream() //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(PaymentStatus[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return defined;
    }

    public boolean isDefined() {
	return defined;
    }
}
