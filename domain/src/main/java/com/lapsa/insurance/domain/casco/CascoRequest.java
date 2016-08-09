package com.lapsa.insurance.domain.casco;

import java.util.ArrayList;
import java.util.List;

import com.lapsa.insurance.domain.InsuranceRequest;
import com.lapsa.insurance.domain.notification.CascoRequestNotification;

public class CascoRequest extends InsuranceRequest {
    private static final long serialVersionUID = -8067548829502589540L;
    private static final int PRIME = 137;
    private static final int MULTIPLIER = PRIME;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

    private Casco casco;
    private List<CascoRequestNotification> notifications;

    public void addNotification(CascoRequestNotification notification) {
	if (notification == null)
	    throw new NullPointerException("Value must not be null");
	if (notification.getCascoRequest() != null)
	    notification.getCascoRequest().removeNotification(notification);
	if (notifications == null)
	    notifications = new ArrayList<>();
	notifications.add(notification);
	notification.setCascoRequest(this);
    }

    public void removeNotification(CascoRequestNotification notification) {
	if (notification == null)
	    throw new NullPointerException("Value must not be null");
	if (notifications == null) // nothing to remove from
	    return;
	notifications.remove(notification);
	notification.setCascoRequest(null);
    }

    // GENERATED

    public Casco getCasco() {
	return casco;
    }

    public void setCasco(Casco casco) {
	this.casco = casco;
    }

    public List<CascoRequestNotification> getNotifications() {
	return notifications;
    }

    public void setNotifications(List<CascoRequestNotification> notifications) {
	this.notifications = notifications;
    }

}
