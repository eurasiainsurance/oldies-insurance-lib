package com.lapsa.insurance.domain;

import com.lapsa.insurance.crm.PaymentStatus;
import com.lapsa.insurance.elements.PaymentMethod;
import com.lapsa.insurance.validation.NotNullValue;

public class PaymentData extends BaseDomain {
    private static final long serialVersionUID = -6326848114328976035L;
    private static final int PRIME = 127;
    private static final int MULTIPLIER = PRIME;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

    @NotNullValue(message = "{com.lapsa.insurance.domain.PaymentData.method.NotNullValue.message}")
    private PaymentMethod method;

    @NotNullValue
    private PaymentStatus status;

    private String paymentReference;

    // GENERATED

    public PaymentMethod getMethod() {
	return method;
    }

    public void setMethod(PaymentMethod method) {
	this.method = method;
    }

    public String getPaymentReference() {
	return paymentReference;
    }

    public void setPaymentReference(String paymentReference) {
	this.paymentReference = paymentReference;
    }

    public PaymentStatus getStatus() {
	return status;
    }

    public void setStatus(PaymentStatus status) {
	this.status = status;
    }
}
