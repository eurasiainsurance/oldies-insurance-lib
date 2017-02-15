package com.lapsa.insurance.domain.policy;

import com.lapsa.insurance.domain.InsuranceProduct;
import com.lapsa.insurance.domain.InsuranceRequest;
import com.lapsa.insurance.elements.InsuranceProductType;

public class PolicyRequest extends InsuranceRequest {
    private static final long serialVersionUID = 944531653617396366L;
    private static final int PRIME = 83;
    private static final int MULTIPLIER = PRIME;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

    private Policy policy = new Policy();

    @Override
    public InsuranceProduct getProduct() {
	return policy;
    }

    @Override
    public InsuranceProductType getProductType() {
	return InsuranceProductType.POLICY;
    }

    // GENERATED

    public Policy getPolicy() {
	return policy;
    }

    public void setPolicy(Policy policy) {
	this.policy = policy;
    }
}
