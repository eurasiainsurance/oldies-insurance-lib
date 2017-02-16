package com.lapsa.insurance.crm;

import com.lapsa.insurance.ElementsBundleBase;

public enum RequestNotificationType implements ElementsBundleBase {
    NEW_REQUEST_USER_EMAIL_NOTIFICATION,
    NEW_REQUEST_COMPANY_EMAIL_NOTIFICATION,
    NEW_REQUEST_COMPANY_PUSH_NOTIFICATION,
    //
    ;

    @Override
    public String canonicalName() {
	return String.format("%1$s.%2$s", this.getClass().getName(), name());
    }
}
