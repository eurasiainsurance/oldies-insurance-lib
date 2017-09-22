package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

public enum PaymentMethod implements InsuranceLocalizedElement {
    PAYCASH, // наличными курьеру
    PAYCARD_ONLINE, // картой на сайте
    UNDEFINED, // не определен
    ;

    //

    private final boolean selectable;

    //

    private PaymentMethod() {
	this.selectable = true;
    }

    private PaymentMethod(boolean selectable) {
	this.selectable = selectable;
    }

    //

    private static final Predicate<PaymentMethod> SELECTABLE_FILTER = PaymentMethod::isSelectable;

    public static final PaymentMethod[] selectableValues() {
	return Stream.of(values()) //
		.filter(SELECTABLE_FILTER) //
		.toArray(PaymentMethod[]::new);
    }

    private static final Predicate<PaymentMethod> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final PaymentMethod[] nonSelectableValues() {
	return Stream.of(values()) //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(PaymentMethod[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }
}
