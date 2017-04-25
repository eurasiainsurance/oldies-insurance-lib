package com.lapsa.insurance.validation.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lapsa.insurance.crm.InsuranceRequestType;
import com.lapsa.insurance.validation.ValidInsuranceRequestTypeValue;
import com.lapsa.insurance.validation.ValidInsuranceRequestTypeValue.ValidationMode;

public class ValidInsuranceRequestTypeValueConstraintValidator
	implements ConstraintValidator<ValidInsuranceRequestTypeValue, InsuranceRequestType> {

    private InsuranceRequestType[] permited;
    private InsuranceRequestType[] denied;
    private ValidationMode mode;

    @Override
    public void initialize(ValidInsuranceRequestTypeValue a) {
	this.permited = a.permited();
	this.denied = a.denied();
	if (ValidationMode.AUTO.equals(a.mode())) {
	    if (this.permited.length > 0)
		this.mode = ValidationMode.DENY_IF_NOT_PERMITED;
	    else if (this.denied.length > 0)
		this.mode = ValidationMode.PERMIT_IF_NOT_DENIED;
	} else
	    this.mode = a.mode();
    }

    @Override
    public boolean isValid(InsuranceRequestType value, ConstraintValidatorContext context) {
	if (value == null)
	    return true;
	switch (mode) {
	case DENY_IF_NOT_PERMITED:
	    for (InsuranceRequestType s : permited)
		if (s.equals(value))
		    return true;
	    return false; // запрещено все, что не разрешено
	case PERMIT_IF_NOT_DENIED:
	    for (InsuranceRequestType s : denied)
		if (s.equals(value))
		    return false;
	    return true; // разрешено все, что не запрещено
	default:
	    return false;
	}
    }

}