package com.lapsa.insurance.services.domain.beans;

import com.lapsa.insurance.domain.BaseDomain;
import com.lapsa.insurance.services.bean.GenericItemService;
import com.lapsa.insurance.services.domain.DomainService;

public abstract class GenericDomainService<T extends BaseDomain> extends GenericItemService<T> implements DomainService<T> {
}
