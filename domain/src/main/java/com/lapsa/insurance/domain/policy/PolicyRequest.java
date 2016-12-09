package com.lapsa.insurance.domain.policy;

import java.util.ArrayList;
import java.util.List;

import com.lapsa.insurance.domain.InsuranceProduct;
import com.lapsa.insurance.domain.InsuranceRequest;
import com.lapsa.insurance.domain.notification.PolicyRequestNotification;
import com.lapsa.insurance.elements.InsuranceProductType;

public class PolicyRequest extends InsuranceRequest {
    private static final long serialVersionUID = 944531653617396366L;
    private static final int PRIME = 83;
    private static final int MULTIPLIER = PRIME;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

    private Policy policy = new Policy();
    private List<PolicyRequestNotification> notifications = new ArrayList<>();

    public void addNotification(PolicyRequestNotification notification) {
	if (notification == null)
	    throw new NullPointerException("Value must not be null");
	if (notification.getPolicyRequest() != null)
	    notification.getPolicyRequest().removeNotification(notification);
	if (notifications == null)
	    notifications = new ArrayList<>();
	notifications.add(notification);
	notification.setPolicyRequest(this);
    }

    public void removeNotification(PolicyRequestNotification notification) {
	if (notification == null)
	    throw new NullPointerException("Value must not be null");
	if (notifications == null) // nothing to remove from
	    return;
	notifications.remove(notification);
	notification.setPolicyRequest(null);
    }

    @Override
    public InsuranceProduct getProduct() {
	return policy;
    }

    @Override
    public InsuranceProductType getProductType() {
	return InsuranceProductType.POLICY;
    }

    // GENERATED

    public Policy getPolicy() {
	return policy;
    }

    public void setPolicy(Policy policy) {
	this.policy = policy;
    }

    public List<PolicyRequestNotification> getNotifications() {
	return notifications;
    }

    public void setNotifications(List<PolicyRequestNotification> notifications) {
	this.notifications = notifications;
    }
}
