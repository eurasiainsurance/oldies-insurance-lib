package com.lapsa.insurance.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateBeforeConstraintValidator implements ConstraintValidator<DateBefore, DateComparision> {

    @Override
    public void initialize(DateBefore constraintAnnotation) {
    }

    @Override
    public boolean isValid(DateComparision value, ConstraintValidatorContext context) {
	if (value == null)
	    return true;
	if (value.leftDate() == null || value.rightDate() == null)
	    return true;
	return value.leftDate().isBefore(value.rightDate());
    }

}