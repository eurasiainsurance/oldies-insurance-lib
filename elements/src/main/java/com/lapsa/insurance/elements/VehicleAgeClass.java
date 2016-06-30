package com.lapsa.insurance.elements;

import com.lapsa.insurance.ElementsBundleBase;

public enum VehicleAgeClass implements ElementsBundleBase {
    UNDER7, // До 7 лет включительно
    OVER7, // Свыше 7 лет
    //
    ;

    @Override
    public String canonicalName() {
	return String.format("%1$s.%2$s", this.getClass().getName(), name());
    }
}
