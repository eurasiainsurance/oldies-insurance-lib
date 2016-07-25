package com.lapsa.insurance.domain.casco;

import com.lapsa.insurance.domain.BaseEntity;

public class SmartCascoData extends BaseEntity<Integer> {
    private static final long serialVersionUID = -1919280207677627360L;
    private static final int PRIME = 131;
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
