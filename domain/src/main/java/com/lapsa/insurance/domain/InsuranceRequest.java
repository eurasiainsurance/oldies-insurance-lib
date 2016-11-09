package com.lapsa.insurance.domain;

import java.util.Date;

import com.lapsa.insurance.crm.RequestStatus;
import com.lapsa.insurance.crm.RequestType;
import com.lapsa.insurance.elements.InsuranceProductType;
import com.lapsa.insurance.validation.NotNullValue;

public abstract class InsuranceRequest extends BaseEntity<Integer> {
    private static final long serialVersionUID = 944531653617396366L;

    private Date created;
    private Date updated;
    private Date closed;

    @NotNullValue
    private RequestStatus status;

    @NotNullValue
    private RequestType type;

    private RequesterData requester;
    private ObtainingData obtaining;
    private PaymentData payment;

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

    public RequestStatus getStatus() {
	return status;
    }

    public void setStatus(RequestStatus status) {
	this.status = status;
    }

    public RequestType getType() {
	return type;
    }

    public void setType(RequestType type) {
	this.type = type;
    }

    public RequesterData getRequester() {
	return requester;
    }

    public void setRequester(RequesterData requester) {
	this.requester = requester;
    }

    public ObtainingData getObtaining() {
	return obtaining;
    }

    public void setObtaining(ObtainingData btaining) {
	this.obtaining = btaining;
    }

    public PaymentData getPayment() {
	return payment;
    }

    public void setPayment(PaymentData payment) {
	this.payment = payment;
    }

    public abstract InsuranceProduct getProduct();

    public abstract InsuranceProductType getProductType();
}
