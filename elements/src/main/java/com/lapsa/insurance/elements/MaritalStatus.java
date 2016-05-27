package com.lapsa.insurance.elements;

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
