package com.lapsa.insurance.crm;

import com.lapsa.insurance.LocalizedElement;

public enum ObtainingStatus implements LocalizedElement {
    PENDING, // ожидается получение
    DONE, // получено
    CANCELED, // отменено
    UNDEFINED, // не определно
    //
    ;
}