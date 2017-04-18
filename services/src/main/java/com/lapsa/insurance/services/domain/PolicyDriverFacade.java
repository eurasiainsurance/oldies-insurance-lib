package com.lapsa.insurance.services.domain;

import com.lapsa.insurance.domain.policy.PolicyDriver;
import com.lapsa.insurance.elements.InsuranceClassType;

public interface PolicyDriverFacade extends DomainService<PolicyDriver> {
    PolicyDriver fetchFromExternalByIdNumber(String idNumber);

    InsuranceClassType getDefaultInsuranceClass();
}
