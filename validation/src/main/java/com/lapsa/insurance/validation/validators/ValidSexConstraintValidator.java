package com.lapsa.insurance.validation.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lapsa.insurance.elements.Sex;
import com.lapsa.insurance.validation.ValidSex;

public class ValidSexConstraintValidator
	implements ConstraintValidator<ValidSex, Sex> {

    private Sex[] invalidTypes;

    @Override
    public void initialize(ValidSex constraintAnnotation) {
	this.invalidTypes = constraintAnnotation.invalidValues();
    }

    @Override
    public boolean isValid(Sex value, ConstraintValidatorContext context) {
	if (value == null)
	    return true;
	for (Sex i : invalidTypes)
	    if (i.equals(value))
		return false;
	return true;
    }

}