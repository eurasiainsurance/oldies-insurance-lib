package com.lapsa.insurance.validation.validators;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.lapsa.insurance.validation.ValidDateOfBirth;

public class ValidDateOfBirthConstraintValidator extends ATemporalConstraintValidator<ValidDateOfBirth> {

    @Override
    public void initialize(ValidDateOfBirth a) {
    }

    @Override
    protected boolean validate(LocalDateTime value) {
	throw unsupportedType(value.getClass());
    }

    @Override
    protected boolean validate(LocalDate value) {
	return true;
    }

    @Override
    protected boolean validate(LocalTime value) {
	throw unsupportedType(value.getClass());
    }

}