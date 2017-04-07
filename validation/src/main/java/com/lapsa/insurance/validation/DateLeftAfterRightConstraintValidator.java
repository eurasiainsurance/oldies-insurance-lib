package com.lapsa.insurance.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateLeftAfterRightConstraintValidator implements ConstraintValidator<DateLeftAfterRight, Object> {

    @Override
    public void initialize(DateLeftAfterRight constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
	if (value == null)
	    return true;

	if (value instanceof LocalDateComparision)
	    return compare((LocalDateComparision) value);

	if (value instanceof LocalDateTimeComparision)
	    return compare((LocalDateTimeComparision) value);

	return true;

    }

    private boolean compare(LocalDateTimeComparision value) {
	if (value.left() == null || value.right() == null)
	    return true;
	return value.left().isAfter(value.right());
    }

    private boolean compare(LocalDateComparision value) {
	if (value.left() == null || value.right() == null)
	    return true;
	return value.left().isAfter(value.right());
    }

}