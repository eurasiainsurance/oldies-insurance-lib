package com.lapsa.insurance.domain.notification;

import com.lapsa.insurance.crm.NotificationRequestStage;
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

    private NotificationRequestStage requestStage;
    private Request request;

    public RequestNotification() {
    }

    public RequestNotification(NotificationRequestStage requestStage) {
	this.requestStage = requestStage;
    }

    public RequestNotification(NotificationRequestStage requestStage, Request request) {
	this.requestStage = requestStage;
	this.request = request;
    }

    // GENERATED

    public NotificationRequestStage getRequestStage() {
	return requestStage;
    }

    public void setRequestStage(NotificationRequestStage requestStage) {
	this.requestStage = requestStage;
    }

    public Request getRequest() {
	return request;
    }

    public void setRequest(Request request) {
	this.request = request;
    }
}
