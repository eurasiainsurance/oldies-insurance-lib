package com.lapsa.insurance.validation.validators;

import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lapsa.insurance.validation.ValidDateOfBirth;

public class ValidDateOfBirthConstraintValidator implements ConstraintValidator<ValidDateOfBirth, Date> {

    public void initialize(ValidDateOfBirth a) {
    }

    public boolean isValid(Date value, ConstraintValidatorContext cvc) {
	return true;
    }

}