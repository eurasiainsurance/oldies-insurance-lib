package com.lapsa.insurance.domain.notification;

public class NewCascoRequestUserNotification extends CascoRequestNotification {
    private static final long serialVersionUID = -2840156800720741710L;
    private static final int PRIME = 41;
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
