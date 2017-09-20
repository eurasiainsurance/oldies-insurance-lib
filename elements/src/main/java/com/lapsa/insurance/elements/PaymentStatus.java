package com.lapsa.insurance.crm;

import com.lapsa.insurance.LocalizedElement;

public enum PaymentStatus implements LocalizedElement {
    PENDING, // ожидается оплата
    DONE, // оплачено
    CANCELED, // отменено
    UNDEFINED, // не определно
    //
    ;
}
