package com.lapsa.insurance.domain;

import java.util.Date;

import com.lapsa.insurance.crm.ClosingResult;
import com.lapsa.insurance.crm.RequestStatus;

public class PolicyExpressOrder extends BaseEntity<Integer> {
    private static final long serialVersionUID = 944531653617396366L;
    private static final int PRIME = 83;
    private static final int MULTIPLIER = 83;

    private Date created;
    private Date updated;
    private Date closed;

    private NotificationData notification;

    private RequestStatus requestStatus;
    private ClosingResult closingResult;

    private PolicyData policy;
    private PloicyRequesterData requester;
    private PolicyObtainingData obtaining;
    private PolicyPaymentData payment;

    private boolean allowSpam;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
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

    public NotificationData getNotification() {
	return notification;
    }

    public void setNotification(NotificationData notification) {
	this.notification = notification;
    }
}
