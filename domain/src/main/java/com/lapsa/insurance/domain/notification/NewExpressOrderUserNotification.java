package com.lapsa.insurance.domain.notification;

public class NewExpressOrderUserNotification extends ExpressOrderNotification {
    private static final long serialVersionUID = 4148318656693578936L;
    private static final int PRIME = 151;
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
