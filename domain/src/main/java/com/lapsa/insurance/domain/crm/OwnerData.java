package com.lapsa.insurance.domain.crm;

import com.lapsa.insurance.domain.BaseDomain;

public class OwnerData extends BaseDomain {
    private static final long serialVersionUID = -8270933167719645431L;
    private static final int PRIME = 59;
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
