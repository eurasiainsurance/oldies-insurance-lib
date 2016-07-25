package com.lapsa.insurance.domain;

import java.util.ArrayList;
import java.util.List;

import com.lapsa.insurance.domain.notification.ExpressOrderNotification;

public class PolicyExpressOrder extends InsuranceRequest {
    private static final long serialVersionUID = 944531653617396366L;
    private static final int PRIME = 83;
    private static final int MULTIPLIER = 83;

    private PolicyData policy;
    private List<ExpressOrderNotification> notifications;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

    public void addNotification(ExpressOrderNotification notification) {
	if (notification == null)
	    throw new NullPointerException("Value must not be null");
	if (notification.getOrder() != null)
	    notification.getOrder().removeNotification(notification);
	if (notifications == null)
	    notifications = new ArrayList<>();
	notifications.add(notification);
	notification.setOrder(this);
    }

    public void removeNotification(ExpressOrderNotification notification) {
	if (notification == null)
	    throw new NullPointerException("Value must not be null");
	if (notifications == null) // nothing to remove from
	    return;
	notifications.remove(notification);
	notification.setOrder(null);
    }

    // GENERATED

    public PolicyData getPolicy() {
	return policy;
    }

    public void setPolicy(PolicyData policy) {
	this.policy = policy;
    }

    public List<ExpressOrderNotification> getNotifications() {
	return notifications;
    }

    public void setNotifications(List<ExpressOrderNotification> notifications) {
	this.notifications = notifications;
    }
}
