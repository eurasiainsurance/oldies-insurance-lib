package com.lapsa.insurance.elements;

public enum PaymentStatus implements LocalizedElement {
    PENDING, // ожидается оплата
    DONE, // оплачено
    CANCELED, // отменено
    UNDEFINED, // не определно
    //
    ;
}
