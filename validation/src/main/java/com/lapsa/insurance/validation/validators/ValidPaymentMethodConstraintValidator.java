package com.lapsa.insurance.validation.validators;

import com.lapsa.insurance.elements.PaymentMethod;
import com.lapsa.insurance.validation.ValidPaymentMethod;

import tech.lapsa.javax.validation.ValidationMode;
import tech.lapsa.javax.validation.constraints.AValidEnumValueConstraintValidator;

public class ValidPaymentMethodConstraintValidator
	extends AValidEnumValueConstraintValidator<ValidPaymentMethod, PaymentMethod> {

    private PaymentMethod[] permited;
    private PaymentMethod[] denied;
    private ValidationMode mode;

    @Override
    public void initialize(ValidPaymentMethod a) {
	this.permited = a.permited();
	this.denied = a.denied();
	this.mode = a.mode();
    }

    @Override
    protected PaymentMethod[] getPermited() {
	return permited;
    }

    @Override
    protected PaymentMethod[] getDenied() {
	return denied;
    }

    @Override
    protected ValidationMode getMode() {
	return mode;
    }

}