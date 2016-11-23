package com.lapsa.insurance.domain.crm;

import java.util.HashMap;
import java.util.Map;

import com.lapsa.insurance.domain.BaseDomain;

public class UTMData extends BaseDomain {
    private static final long serialVersionUID = 2784081894656368503L;
    private static final int PRIME = 29;
    private static final int MULTIPLIER = PRIME;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

    private Map<String, String> tag = new HashMap<>();

    // GENERATED

    public Map<String, String> getTag() {
	return tag;
    }

    public void setTag(Map<String, String> tag) {
	this.tag = tag;
    }

}
