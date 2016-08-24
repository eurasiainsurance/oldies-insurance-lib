package com.lapsa.insurance.crm;

import com.lapsa.insurance.ElementsBundleBase;

public enum ObtainingStatus implements ElementsBundleBase {
    PENDING, // ожидается получение
    DONE, // получено
    CANCELED, // отменено
    //
    ;

    @Override
    public String canonicalName() {
	return String.format("%1$s.%2$s", this.getClass().getName(), name());
    }
}
