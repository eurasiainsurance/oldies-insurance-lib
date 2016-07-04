package com.lapsa.insurance.domain.notification;

import com.lapsa.insurance.domain.PolicyExpressOrder;

public abstract class ExpressOrderNotification extends Notification {
    private static final long serialVersionUID = 7420370408322950098L;

    private PolicyExpressOrder order;

    // GENERATED

    public PolicyExpressOrder getOrder() {
	return order;
    }

    public void setOrder(PolicyExpressOrder order) {
	this.order = order;
    }

}
