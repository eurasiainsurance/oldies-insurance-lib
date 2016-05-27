package com.lapsa.insurance.elements;

public enum SubjectType implements ElementsBundleBase {
    COMPANY, // юрлицо
    PERSON, // физлицо
    //
    ;

    @Override
    public String canonicalName() {
	return String.format("%1$s.%2$s", this.getClass().getName(), name());
    }
}
