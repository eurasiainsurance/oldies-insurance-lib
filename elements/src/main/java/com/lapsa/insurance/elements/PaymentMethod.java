package com.lapsa.insurance.elements;

import com.lapsa.insurance.ElementsBundleBase;

public enum PaymentMethod implements ElementsBundleBase {
    PAYCASH, // наличными курьеру
    PAYCARD_ONLINE, // картой на сайте
    //
    ;

    @Override
    public String canonicalName() {
	return String.format("%1$s.%2$s", this.getClass().getName(), name());
    }
}
