package com.lapsa.insurance.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lapsa.insurance.crm.ClosingResult;
import com.lapsa.insurance.crm.RequestStatus;
import com.lapsa.insurance.domain.notification.ExpressOrderNotification;

public class PolicyExpressOrder extends BaseEntity<Integer> {
    private static final long serialVersionUID = 944531653617396366L;
    private static final int PRIME = 83;
    private static final int MULTIPLIER = 83;

    private Date created;
    private Date updated;
    private Date closed;

    private RequestStatus requestStatus;
    private ClosingResult closingResult;

    private PolicyData policy;
    private PloicyRequesterData requester;
    private PolicyObtainingData obtaining;
    private PolicyPaymentData payment;

    private boolean allowSpam;

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

    public Date getCreated() {
	return created;
    }

    public void setCreated(Date created) {
	this.created = created;
    }

    public Date getUpdated() {
	return updated;
    }

    public void setUpdated(Date updated) {
	this.updated = updated;
    }

    public Date getClosed() {
	return closed;
    }

    public void setClosed(Date closed) {
	this.closed = closed;
    }

    public RequestStatus getRequestStatus() {
	return requestStatus;
    }

    public void setRequestStatus(RequestStatus requestStatus) {
	this.requestStatus = requestStatus;
    }

    public ClosingResult getClosingResult() {
	return closingResult;
    }

    public void setClosingResult(ClosingResult closingResult) {
	this.closingResult = closingResult;
    }

    public PolicyData getPolicy() {
	return policy;
    }

    public void setPolicy(PolicyData policy) {
	this.policy = policy;
    }

    public PloicyRequesterData getRequester() {
	return requester;
    }

    public void setRequester(PloicyRequesterData requester) {
	this.requester = requester;
    }

    public PolicyObtainingData getObtaining() {
	return obtaining;
    }

    public void setObtaining(PolicyObtainingData btaining) {
	this.obtaining = btaining;
    }

    public PolicyPaymentData getPayment() {
	return payment;
    }

    public void setPayment(PolicyPaymentData payment) {
	this.payment = payment;
    }

    public boolean isAllowSpam() {
	return allowSpam;
    }

    public void setAllowSpam(boolean allowSpam) {
	this.allowSpam = allowSpam;
    }

    public List<ExpressOrderNotification> getNotifications() {
	return notifications;
    }

    public void setNotifications(List<ExpressOrderNotification> notifications) {
	this.notifications = notifications;
    }

}
