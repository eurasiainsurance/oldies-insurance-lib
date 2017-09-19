package com.lapsa.insurance.crm;

import com.lapsa.insurance.ElementsBundleBase;

public enum ObtainingStatus implements ElementsBundleBase {
    PENDING, // ожидается получение
    DONE, // получено
    CANCELED, // отменено
    UNDEFINED, // не определно
    //
    ;
}