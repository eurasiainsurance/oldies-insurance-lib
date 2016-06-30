package com.lapsa.insurance.elements;

import com.lapsa.insurance.ElementsBundleBase;

public enum MaritalStatus implements ElementsBundleBase {
    MARRIED, // женат / замужем
    SINGLE, // холост / незамужем
    //
    ;

    @Override
    public String canonicalName() {
	return String.format("%1$s.%2$s", this.getClass().getName(), name());
    }
}
