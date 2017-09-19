package com.lapsa.insurance.elements;

import com.lapsa.insurance.ElementsBundleBase;

public enum PaymentMethod implements ElementsBundleBase {
    PAYCASH, // наличными курьеру
    PAYCARD_ONLINE, // картой на сайте
    UNDEFINED, // не определен
    //
    ;
}
