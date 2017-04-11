package com.lapsa.insurance.validation.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lapsa.insurance.validation.DateLeftBeforeRight;
import com.lapsa.insurance.validation.LocalDateComparision;

public class DateLeftBeforeRightConstraintValidator implements ConstraintValidator<DateLeftBeforeRight, LocalDateComparision> {

    @Override
    public void initialize(DateLeftBeforeRight constraintAnnotation) {
    }

    @Override
    public boolean isValid(LocalDateComparision value, ConstraintValidatorContext context) {
	if (value == null)
	    return true;
	if (value.left() == null || value.right() == null)
	    return true;
	return value.left().isBefore(value.right());
    }

}