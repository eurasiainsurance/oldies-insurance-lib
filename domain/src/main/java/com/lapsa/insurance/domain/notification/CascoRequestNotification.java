package com.lapsa.insurance.domain.notification;

import com.lapsa.insurance.domain.casco.CascoRequest;

public abstract class CascoRequestNotification extends Notification {
    private static final long serialVersionUID = 7932642922201698950L;

    private CascoRequest cascoRequest;

    // GENERATED

    public CascoRequest getCascoRequest() {
	return cascoRequest;
    }

    public void setCascoRequest(CascoRequest cascoRequest) {
	this.cascoRequest = cascoRequest;
    }

}
