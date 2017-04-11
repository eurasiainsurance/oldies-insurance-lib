package com.lapsa.insurance.validation.validators;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lapsa.insurance.validation.NotTooYoungYearOfIssue;

public class NotTooYoungYearOfIssueConstraintValidator
	implements ConstraintValidator<NotTooYoungYearOfIssue, Integer> {

    private int minAge;

    public void initialize(NotTooYoungYearOfIssue a) {
	minAge = a.minAge();
    }

    public boolean isValid(Integer value, ConstraintValidatorContext cvc) {
	if (value == null)
	    return true;
	int nowY = LocalDate.now().getYear();
	int age = nowY - value;
	return age >= minAge;
    }
}