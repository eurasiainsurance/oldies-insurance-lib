package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

public enum PaymentStatus implements LocalizedElement {
    PENDING, // ожидается оплата
    DONE, // оплачено
    CANCELED, // отменено
    UNDEFINED, // не определно
    //
    ;

    private static final Predicate<PaymentStatus> SELECTABLE_FILTER = x -> PaymentStatus.UNDEFINED != x;
    private static final Predicate<PaymentStatus> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final PaymentStatus[] selectableValues() {
	return Stream.of(values()).filter(SELECTABLE_FILTER).toArray(PaymentStatus[]::new);
    }

    public static final PaymentStatus[] nonSelectableValues() {
	return Stream.of(values()).filter(NON_SELECTABLE_FILTER).toArray(PaymentStatus[]::new);
    }
}
