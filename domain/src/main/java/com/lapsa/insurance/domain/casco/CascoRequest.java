package com.lapsa.insurance.domain.casco;

import com.lapsa.insurance.domain.InsuranceRequest;

public class CascoRequest extends InsuranceRequest {
    private static final long serialVersionUID = -8067548829502589540L;
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

    private Casco casco;

    // GENERATED

    public Casco getCasco() {
	return casco;
    }

    public void setCasco(Casco casco) {
	this.casco = casco;
    }

}
