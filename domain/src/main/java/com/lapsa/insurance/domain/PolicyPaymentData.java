package com.lapsa.insurance.domain;

import com.lapsa.insurance.crm.PaymentStatus;
import com.lapsa.insurance.elements.PaymentMethod;
import com.lapsa.insurance.validation.NotNullValue;

public class PolicyPaymentData extends BaseDomain {
    private static final long serialVersionUID = -6326848114328976035L;
    private static final int PRIME = 127;
    private static final int MULTIPLIER = PRIME;

    @NotNullValue(message = "{com.lapsa.insurance.domain.PolicyPaymentData.method.NotNullValue.message}")
    private PaymentMethod method;

    private PaymentStatus status;

    private String kkbOrderId;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

    // GENERATED

    public PaymentMethod getMethod() {
	return method;
    }

    public void setMethod(PaymentMethod method) {
	this.method = method;
    }

    public String getKkbOrderId() {
	return kkbOrderId;
    }

    public void setKkbOrderId(String kkbOrderId) {
	this.kkbOrderId = kkbOrderId;
    }

    public PaymentStatus getStatus() {
	return status;
    }

    public void setStatus(PaymentStatus status) {
	this.status = status;
    }
}
