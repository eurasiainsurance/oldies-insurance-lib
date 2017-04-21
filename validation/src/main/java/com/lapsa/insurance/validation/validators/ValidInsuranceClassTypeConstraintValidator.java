package com.lapsa.insurance.validation.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lapsa.insurance.elements.InsuranceClassType;
import com.lapsa.insurance.validation.ValidInsuranceClassType;

public class ValidInsuranceClassTypeConstraintValidator
	implements ConstraintValidator<ValidInsuranceClassType, InsuranceClassType> {

    @Override
    public void initialize(ValidInsuranceClassType constraintAnnotation) {
    }

    @Override
    public boolean isValid(InsuranceClassType value, ConstraintValidatorContext context) {
	// no invalid values
	return true;
    }

}