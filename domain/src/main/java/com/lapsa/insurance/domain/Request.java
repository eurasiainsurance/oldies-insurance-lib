package com.lapsa.insurance.domain;

import java.time.Instant;

import com.lapsa.insurance.domain.crm.InetAddrData;
import com.lapsa.insurance.domain.crm.UTMData;
import com.lapsa.insurance.domain.crm.User;
import com.lapsa.insurance.elements.ProgressStatus;
import com.lapsa.insurance.elements.RequestSource;
import com.lapsa.insurance.elements.RequestStatus;

import tech.lapsa.java.commons.function.MyOptionals;
import tech.lapsa.javax.validation.NotNullValue;

public abstract class Request extends BaseEntity {

    private static final long serialVersionUID = 1L;

    protected Instant created;
    protected Instant updated;
    protected Instant accepted;
    protected Instant completed;
    protected Instant closed;

    public Request() {
    }

    public Request(RequestSource source) {
	this.source = source;
    }

    @NotNullValue
    protected RequestSource source;

    @NotNullValue
    protected RequestStatus status = RequestStatus.OPEN;

    @NotNullValue
    protected ProgressStatus progressStatus = ProgressStatus.NEW;

    protected RequesterData requester = new RequesterData();

    protected UTMData utmData = new UTMData();
    protected InetAddrData inetAddrData = new InetAddrData();

    protected User createdBy;
    protected User acceptedBy;
    protected User completedBy;
    protected User closedBy;

    protected String note;

    @Override
    public void unlazy() {
	super.unlazy();
	MyOptionals.of(getCreatedBy()).ifPresent(Domain::unlazy);
	MyOptionals.of(getAcceptedBy()).ifPresent(Domain::unlazy);
	MyOptionals.of(getCompletedBy()).ifPresent(Domain::unlazy);
	MyOptionals.of(getClosedBy()).ifPresent(Domain::unlazy);
    }

    // GENERATED

    public Instant getCreated() {
	return created;
    }

    public void setCreated(Instant created) {
	this.created = created;
    }

    public Instant getUpdated() {
	return updated;
    }

    public void setUpdated(Instant updated) {
	this.updated = updated;
    }

    public Instant getClosed() {
	return closed;
    }

    public void setClosed(Instant closed) {
	this.closed = closed;
    }

    public User getCreatedBy() {
	return createdBy;
    }

    public void setCreatedBy(User createdBy) {
	this.createdBy = createdBy;
    }

    public Instant getAccepted() {
	return accepted;
    }

    public void setAccepted(Instant accepted) {
	this.accepted = accepted;
    }

    public Instant getCompleted() {
	return completed;
    }

    public void setCompleted(Instant completed) {
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

    public RequestSource getSource() {
	return source;
    }

    public void setSource(RequestSource source) {
	this.source = source;
    }

    public InetAddrData getInetAddrData() {
	return inetAddrData;
    }

    public void setInetAddrData(InetAddrData inetAddrData) {
	this.inetAddrData = inetAddrData;
    }
}
