package com.lapsa.insurance.elements;

import com.lapsa.insurance.LocalizedElement;

public enum PaymentMethod implements LocalizedElement {
    PAYCASH, // наличными курьеру
    PAYCARD_ONLINE, // картой на сайте
    UNDEFINED, // не определен
    //
    ;
}
