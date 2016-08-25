package com.lapsa.insurance.domain;

import java.util.Date;

import javax.validation.constraints.AssertTrue;

import com.lapsa.insurance.crm.ClosingResult;
import com.lapsa.insurance.crm.RequestStatus;
import com.lapsa.insurance.elements.InsuranceProductType;

public abstract class InsuranceRequest extends BaseEntity<Integer> {
    private static final long serialVersionUID = 944531653617396366L;

    private Date created;
    private Date updated;
    private Date closed;

    private RequestStatus requestStatus;
    private ClosingResult closingResult;

    private RequesterData requester;
    private ObtainingData obtaining;
    private PaymentData payment;
    private boolean allowSpam;

    @AssertTrue(message = "{com.lapsa.insurance.domain.InsuranceRequest.allowProcessPersonalData.AssertTrue.message}")
    private boolean allowProcessPersonalData;

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

    public boolean isAllowSpam() {
	return allowSpam;
    }

    public void setAllowSpam(boolean allowSpam) {
	this.allowSpam = allowSpam;
    }

    public boolean isAllowProcessPersonalData() {
	return allowProcessPersonalData;
    }

    public void setAllowProcessPersonalData(boolean allowProcessPersonalData) {
	this.allowProcessPersonalData = allowProcessPersonalData;
    }

    public abstract InsuranceProduct getProduct();

    public abstract InsuranceProductType getProductType();
}
