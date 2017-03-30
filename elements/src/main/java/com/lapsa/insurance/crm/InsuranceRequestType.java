package com.lapsa.insurance.crm;

import com.lapsa.insurance.ElementsBundleBase;

public enum InsuranceRequestType implements ElementsBundleBase {
    EXPRESS, // экспресс
    ONLINE, // он-лайн
    API, // получено через API веб-сервиса
    UNCOMPLETE, // лид
    //
    ;

    @Override
    public String canonicalName() {
	return String.format("%1$s.%2$s", this.getClass().getName(), name());
    }
}
