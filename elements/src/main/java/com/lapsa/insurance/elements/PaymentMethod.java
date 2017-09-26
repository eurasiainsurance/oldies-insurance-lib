package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

import com.lapsa.commons.elements.LocalizedElement;

public enum PaymentMethod implements LocalizedElement {
    PAYCASH, // наличными курьеру
    PAYCARD_ONLINE, // картой на сайте
    UNDEFINED(false), // не определен
    ;

    //

    private final boolean defined;

    //

    private PaymentMethod() {
	this.defined = true;
    }

    private PaymentMethod(boolean selectable) {
	this.defined = selectable;
    }

    //

    public static final Stream<PaymentMethod> valuesStream() {
	return Stream.of(values());
    }

    //

    private static final Predicate<PaymentMethod> SELECTABLE_FILTER = PaymentMethod::isSelectable;

    public static final PaymentMethod[] selectableValues() {
	return valuesStream() //
		.filter(SELECTABLE_FILTER) //
		.toArray(PaymentMethod[]::new);
    }

    private static final Predicate<PaymentMethod> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final PaymentMethod[] nonSelectableValues() {
	return valuesStream() //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(PaymentMethod[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return defined;
    }

    public boolean isDefined() {
	return defined;
    }
}
