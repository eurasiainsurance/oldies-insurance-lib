package com.lapsa.insurance.elements;

public enum InsuredExpirienceClass implements ElementsBundleBase {
    MORE2, // стаж вождения более 2 лет
    LESS2, // стаж вождения менее 2 лет
    //
    ;

    @Override
    public String canonicalName() {
	return String.format("%1$s.%2$s", this.getClass().getName(), name());
    }
}
