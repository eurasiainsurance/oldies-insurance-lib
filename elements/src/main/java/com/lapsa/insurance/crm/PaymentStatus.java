package com.lapsa.insurance.crm;

import com.lapsa.insurance.ElementsBundleBase;

public enum PaymentStatus implements ElementsBundleBase {
    PENDING, // ожидается оплата
    DONE, // оплачено
    CANCELED, // отменено
    UNDEFINED, // не определно
    //
    ;
}
