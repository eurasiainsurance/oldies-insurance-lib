package com.lapsa.insurance.domain.casco;

import com.lapsa.insurance.domain.BaseEntity;
import com.lapsa.insurance.domain.CalculationData;

public class SmartCascoData extends BaseEntity<Integer> {
    private static final long serialVersionUID = -1919280207677627360L;
    private static final int PRIME = 131;
    private static final int MULTIPLIER = PRIME;

    private CalculationData calculation;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

    public CalculationData getCalculation() {
	return calculation;
    }

    public void setCalculation(CalculationData calculation) {
	this.calculation = calculation;
    }
}
