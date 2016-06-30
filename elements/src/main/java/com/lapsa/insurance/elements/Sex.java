package com.lapsa.insurance.elements;

import com.lapsa.insurance.ElementsBundleBase;

public enum Sex implements ElementsBundleBase {
    MALE, // мужской
    FEMALE, // женский
    //
    ;

    @Override
    public String canonicalName() {
	return String.format("%1$s.%2$s", this.getClass().getName(), name());
    }
}
