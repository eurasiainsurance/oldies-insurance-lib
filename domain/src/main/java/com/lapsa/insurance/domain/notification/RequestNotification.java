package com.lapsa.insurance.domain.notification;

import com.lapsa.insurance.crm.RequestNotificationType;
import com.lapsa.insurance.domain.Request;

public class RequestNotification extends Notification {
    private static final long serialVersionUID = 7362333986775221775L;
    private static final int PRIME = 167;
    private static final int MULTIPLIER = PRIME;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

    private RequestNotificationType type;
    private Request request;

    public RequestNotification() {
    }
    
    public RequestNotification(RequestNotificationType type) {
	this.type = type;
    }

    public RequestNotification(RequestNotificationType type, Request request) {
	this.type = type;
	this.request = request;
    }

    // GENERATED

    public RequestNotificationType getType() {
	return type;
    }

    public void setType(RequestNotificationType type) {
	this.type = type;
    }

    public Request getRequest() {
	return request;
    }

    public void setRequest(Request request) {
	this.request = request;
    }
}
