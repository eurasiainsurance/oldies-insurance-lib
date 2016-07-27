package com.lapsa.insurance.domain.notification;

import com.lapsa.insurance.domain.policy.PolicyRequest;

public abstract class ExpressOrderNotification extends Notification {
    private static final long serialVersionUID = 7420370408322950098L;

    private PolicyRequest order;

    // GENERATED

    public PolicyRequest getOrder() {
	return order;
    }

    public void setOrder(PolicyRequest order) {
	this.order = order;
    }

}
