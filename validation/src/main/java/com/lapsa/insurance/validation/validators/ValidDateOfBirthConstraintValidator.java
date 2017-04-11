package com.lapsa.insurance.validation;

import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidDateOfBirthConstraintValidator implements ConstraintValidator<ValidDateOfBirth, Date> {

    public void initialize(ValidDateOfBirth a) {
    }

    public boolean isValid(Date value, ConstraintValidatorContext cvc) {
	return true;
    }

}