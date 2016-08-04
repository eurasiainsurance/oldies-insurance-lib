package com.lapsa.insurance.domain.notification;

public class NewCascoRequestCompanyNotification extends CascoRequestNotification {
    private static final long serialVersionUID = -8994421540787716726L;
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
