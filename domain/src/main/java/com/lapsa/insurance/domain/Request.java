package com.lapsa.insurance.domain;

import java.util.Date;

import com.lapsa.insurance.crm.ProgressStatus;
import com.lapsa.insurance.crm.RequestStatus;
import com.lapsa.insurance.domain.crm.UTMData;
import com.lapsa.insurance.domain.crm.User;
import com.lapsa.insurance.validation.NotNullValue;

public abstract class Request extends BaseEntity<Integer> {
    private static final long serialVersionUID = -4738852384873507942L;
    private Date created = new Date();
    private Date updated;
    private Date accepted;
    private Date completed;
    private Date closed;

    @NotNullValue
    private RequestStatus status = RequestStatus.OPEN;

    @NotNullValue
    private ProgressStatus progressStatus = ProgressStatus.NEW;

    private RequesterData requester = new RequesterData();

    private UTMData utmData = new UTMData();

    private User acceptedBy;
    private User completedBy;
    private User closedBy;

    private String note;

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

    public Date getAccepted() {
	return accepted;
    }

    public void setAccepted(Date accepted) {
	this.accepted = accepted;
    }

    public Date getCompleted() {
	return completed;
    }

    public void setCompleted(Date completed) {
	this.completed = completed;
    }

    public RequestStatus getStatus() {
	return status;
    }

    public void setStatus(RequestStatus status) {
	this.status = status;
    }

    public ProgressStatus getProgressStatus() {
	return progressStatus;
    }

    public void setProgressStatus(ProgressStatus progressStatus) {
	this.progressStatus = progressStatus;
    }

    public RequesterData getRequester() {
	return requester;
    }

    public void setRequester(RequesterData requester) {
	this.requester = requester;
    }

    public UTMData getUtmData() {
	return utmData;
    }

    public void setUtmData(UTMData utmData) {
	this.utmData = utmData;
    }

    public User getAcceptedBy() {
	return acceptedBy;
    }

    public void setAcceptedBy(User acceptedBy) {
	this.acceptedBy = acceptedBy;
    }

    public User getCompletedBy() {
	return completedBy;
    }

    public void setCompletedBy(User completedBy) {
	this.completedBy = completedBy;
    }

    public User getClosedBy() {
	return closedBy;
    }

    public void setClosedBy(User closedBy) {
	this.closedBy = closedBy;
    }

    public String getNote() {
	return note;
    }

    public void setNote(String note) {
	this.note = note;
    }
}
