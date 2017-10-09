package com.lapsa.insurance.validation.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lapsa.insurance.elements.VehicleClass;
import com.lapsa.insurance.validation.ValidPolicyVehicleClass;

public class ValidPolicyVehicleClassConstraintValidator
	implements ConstraintValidator<ValidPolicyVehicleClass, VehicleClass> {

    @Override
    public void initialize(ValidPolicyVehicleClass constraintAnnotation) {
    }

    @Override
    public boolean isValid(VehicleClass value, ConstraintValidatorContext context) {
	if (value == null)
	    return true;
	return value.isValidForMotorTPL();
    }

}