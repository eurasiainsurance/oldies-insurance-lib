package com.lapsa.insurance.validation.validators;

import java.util.Calendar;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lapsa.insurance.validation.ValidVehicleYearOfIssue;

public class ValidVehicleYearOfIssueConstraintValidator implements ConstraintValidator<ValidVehicleYearOfIssue, Integer> {

    private int minValue;

    @Override
    public void initialize(ValidVehicleYearOfIssue constraintAnnotation) {
	this.minValue = constraintAnnotation.minValue();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
	if (value == null)
	    return true;
	if (value < minValue)
	    return false;
	Calendar now = Calendar.getInstance();
	if (value > now.get(Calendar.YEAR))
	    return false;
	return true;
    }
}
