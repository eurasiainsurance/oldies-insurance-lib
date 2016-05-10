package com.lapsa.insurance.validation;

import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidDateOfIssueConstraintValidator implements ConstraintValidator<ValidDateOfIssue, Date> {

    public void initialize(ValidDateOfIssue a) {
    }

    public boolean isValid(Date value, ConstraintValidatorContext cvc) {
	return true;
    }

}