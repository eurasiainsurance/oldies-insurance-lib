package com.lapsa.insurance.validation.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lapsa.insurance.validation.NotEmptyString;

public class NotEmptyStringConstraintValidator implements ConstraintValidator<NotEmptyString, String> {

    private boolean trimSpaces;

    public void initialize(NotEmptyString a) {
	this.trimSpaces = a.trimSpaces();
    }

    public boolean isValid(String value, ConstraintValidatorContext cvc) {
	if (value == null)
	    return true;
	if (trimSpaces)
	    return !value.trim().isEmpty();
	else
	    return !value.isEmpty();
    }

}