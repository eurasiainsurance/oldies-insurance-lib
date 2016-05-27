package com.lapsa.insurance.elements;

public enum PolicyObtainingMethod implements ElementsBundleBase {
    EXPRESS, // доставить курьером
    PICKUP, // забрать самостоятельно в офисе компании
    //
    ;

    @Override
    public String canonicalName() {
	return String.format("%1$s.%2$s", this.getClass().getName(), name());
    }
}
