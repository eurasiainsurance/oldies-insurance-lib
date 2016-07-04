package com.lapsa.insurance.domain.notification;

public class KKBSendPaymentLinkUserNotification extends ExpressOrderNotification {
    private static final long serialVersionUID = 3795074579046529472L;
    private static final int PRIME = 139;
    private static final int MULTIPLIER = PRIME;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }
}
