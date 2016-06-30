package com.lapsa.insurance.crm;

import com.lapsa.insurance.ElementsBundleBase;

public enum ClosingResult implements ElementsBundleBase {
    COMPLETED, // Выполнено
    CANCELED, // Отменено
    //
    ;

    @Override
    public String canonicalName() {
	return String.format("%1$s.%2$s", this.getClass().getName(), name());
    }
}
