package com.lapsa.insurance.elements;

import com.lapsa.insurance.ElementsBundleBase;

public enum CascoCarAgeClass implements ElementsBundleBase {
    UNDER3, // до 3 лет
    FROM3TO7, // от 3 до 7 лет
    ;

    @Override
    public String canonicalName() {
	return String.format("%1$s.%2$s", this.getClass().getName(), name());
    }
}
