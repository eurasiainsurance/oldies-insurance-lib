package com.lapsa.insurance.validation.validators;

import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lapsa.insurance.validation.ValidDateOfIssue;

public class ValidDateOfIssueConstraintValidator implements ConstraintValidator<ValidDateOfIssue, Date> {

    public void initialize(ValidDateOfIssue a) {
    }

    public boolean isValid(Date value, ConstraintValidatorContext cvc) {
	return true;
    }

}