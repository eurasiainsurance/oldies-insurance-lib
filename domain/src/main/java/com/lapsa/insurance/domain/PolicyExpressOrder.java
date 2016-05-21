package com.lapsa.insurance.domain;

import java.util.Date;

import com.lapsa.insurance.crm.ClosingResult;
import com.lapsa.insurance.crm.RequestStatus;

public class PolicyExpressOrder extends BaseDomain<Integer> {

    private Date created;
    private Date updated;
    private Date closed;
    private RequestStatus requestStatus;
    private ClosingResult closingResult;

    private PolicyData policy;
    private PloicyRequesterData requester;
    private PolicyObtainingData obtaininig;

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

    public PolicyObtainingData getObtaininig() {
	return obtaininig;
    }

    public void setObtaininig(PolicyObtainingData obtaininig) {
	this.obtaininig = obtaininig;
    }
}
