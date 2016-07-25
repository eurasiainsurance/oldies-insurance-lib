package com.lapsa.insurance.domain.casco;

import com.lapsa.insurance.domain.InsuranceRequest;

public class SmartCascoRequest extends InsuranceRequest {
    private static final long serialVersionUID = -8067548829502589540L;
    private static final int PRIME = 137;
    private static final int MULTIPLIER = PRIME;

    private SmartCascoData smartCasco;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

    // GENERATED

    public SmartCascoData getSmartCasco() {
	return smartCasco;
    }

    public void setSmartCasco(SmartCascoData smartCasco) {
	this.smartCasco = smartCasco;
    }

}
