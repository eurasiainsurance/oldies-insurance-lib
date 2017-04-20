package com.lapsa.insurance.validation.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lapsa.insurance.elements.VehicleAgeClass;
import com.lapsa.insurance.validation.ValidPolicyVehicleAgeClass;

public class ValidPolicyVehicleAgeClassConstraintValidator
	implements ConstraintValidator<ValidPolicyVehicleAgeClass, VehicleAgeClass> {

    @Override
    public void initialize(ValidPolicyVehicleAgeClass constraintAnnotation) {
    }

    @Override
    public boolean isValid(VehicleAgeClass value, ConstraintValidatorContext context) {
	// no invalid values
	return true;
    }

}