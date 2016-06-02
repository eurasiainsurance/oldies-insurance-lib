package com.lapsa.insurance.domain.services.beans;

import java.util.Locale;

import com.lapsa.insurance.domain.BaseDomain;
import com.lapsa.insurance.domain.services.DomainService;
import com.lapsa.insurance.elements.services.beans.GenericItemService;

public abstract class GenericDomainService<T extends BaseDomain> extends GenericItemService<T> implements DomainService<T> {

    @Override
    public String displayNameShort(T value) {
	return displayName(value);
    }

    @Override
    public String displayNameShort(T value, Locale locale) {
	return displayName(value, locale);
    }

}
