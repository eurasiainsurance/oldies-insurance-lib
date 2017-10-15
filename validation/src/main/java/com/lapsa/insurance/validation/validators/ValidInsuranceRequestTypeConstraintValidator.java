package com.lapsa.insurance.validation.validators;

import com.lapsa.insurance.elements.InsuranceRequestType;
import com.lapsa.insurance.validation.ValidInsuranceRequestType;

import tech.lapsa.javax.validation.ValidationMode;
import tech.lapsa.javax.validation.constraints.AValidEnumValueConstraintValidator;

public class ValidInsuranceRequestTypeConstraintValidator
	extends AValidEnumValueConstraintValidator<ValidInsuranceRequestType, InsuranceRequestType> {

    private InsuranceRequestType[] permited;
    private InsuranceRequestType[] denied;
    private ValidationMode mode;

    @Override
    public void initialize(ValidInsuranceRequestType a) {
	this.permited = a.permited();
	this.denied = a.denied();
	this.mode = a.mode();
    }

    @Override
    protected InsuranceRequestType[] getPermited() {
	return permited;
    }

    @Override
    protected InsuranceRequestType[] getDenied() {
	return denied;
    }

    @Override
    protected ValidationMode getMode() {
	return mode;
    }

}