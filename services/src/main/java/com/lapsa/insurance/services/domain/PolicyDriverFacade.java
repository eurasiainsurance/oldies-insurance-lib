package com.lapsa.insurance.services.domain;

import com.lapsa.insurance.domain.policy.PolicyDriver;

public interface PolicyDriverFacade extends DomainService<PolicyDriver> {
    PolicyDriver fetchFromExternalByIdNumber(String idNumber);
}
