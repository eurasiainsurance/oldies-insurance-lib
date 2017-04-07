package com.lapsa.insurance.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateAfterConstraintValidator implements ConstraintValidator<DateAfter, DateComparision> {

    @Override
    public void initialize(DateAfter constraintAnnotation) {
    }

    @Override
    public boolean isValid(DateComparision value, ConstraintValidatorContext context) {
	if (value == null)
	    return true;
	if (value.leftDate() == null || value.rightDate() == null)
	    return true;
	return value.leftDate().isAfter(value.rightDate());
    }

}