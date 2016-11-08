package com.lapsa.insurance.crm;

import com.lapsa.insurance.ElementsBundleBase;

public enum ProgressStatus implements ElementsBundleBase {
    NEW, //
    ON_PROCESS, //
    ON_HOLD, //
    COMPLETED, //
    ;

    @Override
    public String canonicalName() {
	return String.format("%1$s.%2$s", this.getClass().getName(), name());
    }
}
