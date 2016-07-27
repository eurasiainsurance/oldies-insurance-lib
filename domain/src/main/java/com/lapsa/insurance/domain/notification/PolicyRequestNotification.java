package com.lapsa.insurance.domain.notification;

import com.lapsa.insurance.domain.policy.PolicyRequest;

public abstract class PolicyRequestNotification extends Notification {
    private static final long serialVersionUID = 7420370408322950098L;

    private PolicyRequest policyRequest;

    // GENERATED

    public PolicyRequest getPolicyRequest() {
	return policyRequest;
    }

    public void setPolicyRequest(PolicyRequest policyRequest) {
	this.policyRequest = policyRequest;
    }

}
