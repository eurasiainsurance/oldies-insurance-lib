package com.lapsa.insurance.crm;

import com.lapsa.insurance.ElementsBundleBase;

public enum TransactionProblem implements ElementsBundleBase {
    CANCELED_BY_CONSUMER, //
    WRONG_DATA_PROVIDED, //
    TEST, //
    DUPLICATE,
    OTHER, //
    ;

    @Override
    public String canonicalName() {
	return String.format("%1$s.%2$s", this.getClass().getName(), name());
    }
}
