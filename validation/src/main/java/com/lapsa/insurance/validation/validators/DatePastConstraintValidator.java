package com.lapsa.insurance.validation.validators;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.lapsa.insurance.validation.DatePast;

public class DatePastConstraintValidator extends ATemporalConstraintValidator<DatePast> {

    @Override
    public void initialize(DatePast constraintAnnotation) {
    }

    @Override
    protected boolean validate(LocalDateTime value) {
	return value.isBefore(LocalDateTime.now());
    }

    @Override
    protected boolean validate(LocalDate value) {
	return value.isBefore(LocalDate.now());
    }

    @Override
    protected boolean validate(LocalTime value) {
	return value.isBefore(LocalTime.now());
    }

}
