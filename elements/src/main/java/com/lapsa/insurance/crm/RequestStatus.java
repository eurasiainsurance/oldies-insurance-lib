package com.lapsa.insurance.crm;

import com.lapsa.insurance.elements.ElementsBundleBase;

public enum RequestStatus implements ElementsBundleBase {
    OPEN, // Открыто
    CLOSED, // Закрыто
    //
    ;

    @Override
    public String canonicalName() {
	return String.format("%1$s.%2$s", this.getClass().getName(), name());
    }
}
