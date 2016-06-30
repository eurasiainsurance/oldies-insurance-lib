package com.lapsa.insurance.domain;

import com.lapsa.insurance.crm.NotificationStatus;

public class NotificationData extends BaseDomain {
    private static final long serialVersionUID = -6887225230988200072L;
    private static final int PRIME = 131;
    private static final int MULTIPLIER = PRIME;

    private NotificationStatus userNotificationStatus;
    private NotificationStatus companyNotificationStatus;
    private NotificationStatus kkbPaymentURLNotification;
    private NotificationStatus kkbPaymentSuccessNotification;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

    // GENERATED
    public NotificationStatus getUserNotificationStatus() {
	return userNotificationStatus;
    }

    public void setUserNotificationStatus(NotificationStatus userNotificationStatus) {
	this.userNotificationStatus = userNotificationStatus;
    }

    public NotificationStatus getCompanyNotificationStatus() {
	return companyNotificationStatus;
    }

    public void setCompanyNotificationStatus(NotificationStatus companyNotificationStatus) {
	this.companyNotificationStatus = companyNotificationStatus;
    }

    public NotificationStatus getKkbPaymentURLNotification() {
	return kkbPaymentURLNotification;
    }

    public void setKkbPaymentURLNotification(NotificationStatus kkbPaymentURLNotification) {
	this.kkbPaymentURLNotification = kkbPaymentURLNotification;
    }

    public NotificationStatus getKkbPaymentSuccessNotification() {
	return kkbPaymentSuccessNotification;
    }

    public void setKkbPaymentSuccessNotification(NotificationStatus kkbPaymentSuccessNotification) {
	this.kkbPaymentSuccessNotification = kkbPaymentSuccessNotification;
    }

}
