package com.lapsa.insurance.validation.validators;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.lapsa.insurance.validation.DateLeftBeforeRight;

public class DateLeftAfterRightConstraintValidator extends ATemporalLeftRightConstraintValidator<DateLeftBeforeRight> {

    @Override
    public void initialize(DateLeftBeforeRight constraintAnnotation) {
    }

    @Override
    protected boolean compare(LocalDateTime left, LocalDateTime right) {
	if (left == null || right == null)
	    return true;
	return left.isAfter(right);
    }

    @Override
    protected boolean compare(LocalDate left, LocalDate right) {
	if (left == null || right == null)
	    return true;
	return left.isAfter(right);
    }

}