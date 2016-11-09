package com.lapsa.insurance.crm;

import com.lapsa.insurance.ElementsBundleBase;

public enum TransactionStatus implements ElementsBundleBase {
    COMPLETED, // Сделка состоялась
    NOT_COMPLETED, // Сделка не состоялась
    ;

    @Override
    public String canonicalName() {
	return String.format("%1$s.%2$s", this.getClass().getName(), name());
    }
}
