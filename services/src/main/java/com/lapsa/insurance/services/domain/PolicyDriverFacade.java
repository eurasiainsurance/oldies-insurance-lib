package com.lapsa.insurance.services.domain;

import com.lapsa.insurance.domain.policy.PolicyDriver;
import com.lapsa.insurance.elements.InsuranceClassType;

public interface PolicyDriverFacade extends DomainService<PolicyDriver> {
    PolicyDriver fetchByIdNumber(String idNumber);

    void fetch(PolicyDriver value);

    void clearFetched(PolicyDriver value);

    InsuranceClassType getDefaultInsuranceClass();
}
