package com.lapsa.insurance.domain.notification;

public class NewPolicyRequestCompanyNotification extends PolicyRequestNotification {
    private static final long serialVersionUID = -9111687668041850976L;
    private static final int PRIME = 149;
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
