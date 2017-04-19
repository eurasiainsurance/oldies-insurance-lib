package com.lapsa.insurance.domain;

import java.time.LocalDateTime;

import com.lapsa.insurance.crm.ProgressStatus;
import com.lapsa.insurance.crm.RequestStatus;
import com.lapsa.insurance.domain.crm.UTMData;
import com.lapsa.insurance.domain.crm.User;
import com.lapsa.validation.NotNullValue;

public abstract class Request extends BaseEntity<Integer> {
    private static final long serialVersionUID = -4738852384873507942L;
    private LocalDateTime created;
    private LocalDateTime updated;
    private LocalDateTime accepted;
    private LocalDateTime completed;
    private LocalDateTime closed;

    @NotNullValue
    private RequestStatus status = RequestStatus.OPEN;

    @NotNullValue
    private ProgressStatus progressStatus = ProgressStatus.NEW;

    private RequesterData requester = new RequesterData();

    private UTMData utmData = new UTMData();

    private User createdBy;
    private User acceptedBy;
    private User completedBy;
    private User closedBy;

    private String note;

    // GENERATED

    public LocalDateTime getCreated() {
	return created;
    }

    public void setCreated(LocalDateTime created) {
	this.created = created;
    }

    public LocalDateTime getUpdated() {
	return updated;
    }

    public void setUpdated(LocalDateTime updated) {
	this.updated = updated;
    }

    public LocalDateTime getClosed() {
	return closed;
    }

    public void setClosed(LocalDateTime closed) {
	this.closed = closed;
    }

    public User getCreatedBy() {
	return createdBy;
    }

    public void setCreatedBy(User createdBy) {
	this.createdBy = createdBy;
    }

    public LocalDateTime getAccepted() {
	return accepted;
    }

    public void setAccepted(LocalDateTime accepted) {
	this.accepted = accepted;
    }

    public LocalDateTime getCompleted() {
	return completed;
    }

    public void setCompleted(LocalDateTime completed) {
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
