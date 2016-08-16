package com.lapsa.insurance.domain.casco;

import com.lapsa.insurance.domain.Driver;

public class CascoDriver extends Driver {
    private static final long serialVersionUID = 6781864890008476284L;
    private static final int PRIME = 113;
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
