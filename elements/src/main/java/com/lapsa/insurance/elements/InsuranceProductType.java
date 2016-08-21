package com.lapsa.insurance.elements;

import com.lapsa.insurance.ElementsBundleBase;

public enum InsuranceProductType implements ElementsBundleBase {
    POLICY, // Полис ОС ГПО ВТС
    CASCO, // Авто КАСКО
    //
    ;

    @Override
    public String canonicalName() {
	return String.format("%1$s.%2$s", this.getClass().getName(), name());
    }
}
