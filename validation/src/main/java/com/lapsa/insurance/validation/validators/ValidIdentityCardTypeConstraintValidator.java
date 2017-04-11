package com.lapsa.insurance.validation.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lapsa.insurance.elements.IdentityCardType;
import com.lapsa.insurance.validation.ValidIdentityCardType;

public class ValidIdentityCardTypeConstraintValidator
	implements ConstraintValidator<ValidIdentityCardType, IdentityCardType> {

    private IdentityCardType[] invalidValues;

    @Override
    public void initialize(ValidIdentityCardType constraintAnnotation) {
	this.invalidValues = constraintAnnotation.invalidValues();
    }

    @Override
    public boolean isValid(IdentityCardType value, ConstraintValidatorContext context) {
	if (value == null)
	    return true;
	for (IdentityCardType i : invalidValues)
	    if (i.equals(value))
		return false;
	return true;
    }

}