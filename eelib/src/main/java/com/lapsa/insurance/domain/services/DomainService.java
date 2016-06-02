package com.lapsa.insurance.domain.services;

import com.lapsa.insurance.domain.BaseDomain;
import com.lapsa.insurance.elements.services.ItemService;

public interface DomainService<T extends BaseDomain> extends ItemService<T> {
}
