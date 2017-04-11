package com.lapsa.insurance.validation;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DaysAfterNowConstraintValidator implements ConstraintValidator<DaysAfterNow, Date> {

    private Mode mode;
    private long days;

    @Override
    public void initialize(DaysAfterNow constraintAnnotation) {
	this.mode = constraintAnnotation.mode();
	this.days = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(Date value, ConstraintValidatorContext context) {
	if (value == null)
	    return true;
	switch (mode) {
	case MUST_NOT:
	    return value.toInstant().isAfter(Instant.now().minus(days, ChronoUnit.DAYS));
	case MUST:
	default:
	    return value.toInstant().isAfter(Instant.now().plus(days, ChronoUnit.DAYS));
	}

    }

}