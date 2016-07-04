package com.lapsa.insurance.domain.notification;

public class KKBPaymentSuccessUserNotification extends ExpressOrderNotification {
    private static final long serialVersionUID = -137681696084988399L;
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
}
