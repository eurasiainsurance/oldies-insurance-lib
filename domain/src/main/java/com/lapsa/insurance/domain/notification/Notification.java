package com.lapsa.insurance.domain.notification;

import java.util.Date;

import com.lapsa.insurance.crm.NotificationStatus;
import com.lapsa.insurance.domain.BaseEntity;

public abstract class Notification extends BaseEntity<Integer> {
    private static final long serialVersionUID = -1902885458072366192L;

    private Date created = new Date();
    private Date updated;
    private Date sent;
    private NotificationStatus status = NotificationStatus.PENDING;

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

    public Date getSent() {
	return sent;
    }

    public void setSent(Date sent) {
	this.sent = sent;
    }

    public NotificationStatus getStatus() {
	return status;
    }

    public void setStatus(NotificationStatus status) {
	this.status = status;
    }
}
