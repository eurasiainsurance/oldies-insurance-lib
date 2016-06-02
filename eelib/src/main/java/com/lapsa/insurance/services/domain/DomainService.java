package com.lapsa.insurance.services.domain;

import com.lapsa.insurance.domain.BaseDomain;
import com.lapsa.insurance.services.ItemService;

public interface DomainService<T extends BaseDomain> extends ItemService<T> {
}
