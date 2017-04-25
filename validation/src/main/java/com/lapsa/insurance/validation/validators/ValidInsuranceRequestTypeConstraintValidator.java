package com.lapsa.insurance.validation.validators;

import com.lapsa.insurance.crm.InsuranceRequestType;
import com.lapsa.insurance.validation.ValidInsuranceRequestTypeValue;
import com.lapsa.validation.ValidationMode;
import com.lapsa.validation.constraints.AValidEnumValueConstraintValidator;

public class ValidInsuranceRequestTypeValueConstraintValidator
	extends AValidEnumValueConstraintValidator<ValidInsuranceRequestTypeValue, InsuranceRequestType> {

    private InsuranceRequestType[] permited;
    private InsuranceRequestType[] denied;
    private ValidationMode mode;

    @Override
    public void initialize(ValidInsuranceRequestTypeValue a) {
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