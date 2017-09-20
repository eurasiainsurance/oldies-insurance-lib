package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

public enum PaymentMethod implements LocalizedElement {
    PAYCASH, // наличными курьеру
    PAYCARD_ONLINE, // картой на сайте
    UNDEFINED, // не определен
    //
    ;

    private static final Predicate<PaymentMethod> SELECTABLE_FILTER = x -> PaymentMethod.UNDEFINED != x;
    private static final Predicate<PaymentMethod> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final PaymentMethod[] selectableValues() {
	return Stream.of(values()).filter(SELECTABLE_FILTER).toArray(PaymentMethod[]::new);
    }

    public static final PaymentMethod[] nonSelectableValues() {
	return Stream.of(values()).filter(NON_SELECTABLE_FILTER).toArray(PaymentMethod[]::new);
    }
}
