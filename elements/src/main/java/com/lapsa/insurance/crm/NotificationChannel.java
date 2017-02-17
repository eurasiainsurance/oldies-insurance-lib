package com.lapsa.insurance.crm;

import com.lapsa.insurance.ElementsBundleBase;

public enum NotificationChannel implements ElementsBundleBase {
    EMAIL, PUSH, SMS;

    @Override
    public String canonicalName() {
	return String.format("%1$s.%2$s", this.getClass().getName(), name());
    }
}
