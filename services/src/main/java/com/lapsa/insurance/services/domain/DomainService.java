package com.lapsa.insurance.services.domain;

import com.lapsa.insurance.domain.BaseDomain;
import com.lapsa.insurance.services.ItemNamingService;

public interface DomainService<T extends BaseDomain> extends ItemNamingService<T> {
}
