package com.lapsa.insurance.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lapsa.insurance.elements.InsuredExpirienceClass;

public class ValidInsuranceExpirienceClassConstraintValidator
	implements ConstraintValidator<ValidInsuranceExpirienceClass, InsuredExpirienceClass> {

    private InsuredExpirienceClass[] invalidTypes;

    @Override
    public void initialize(ValidInsuranceExpirienceClass constraintAnnotation) {
	this.invalidTypes = constraintAnnotation.invalidValues();
    }

    @Override
    public boolean isValid(InsuredExpirienceClass value, ConstraintValidatorContext context) {
	if (value == null)
	    return true;
	for (InsuredExpirienceClass i : invalidTypes)
	    if (i.equals(value))
		return false;
	return true;
    }

}