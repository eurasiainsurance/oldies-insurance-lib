package com.lapsa.insurance.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidVehicleRegistrationNumberConstraintValidator
	implements ConstraintValidator<ValidVehicleRegistrationNumber, String> {

    public void initialize(ValidVehicleRegistrationNumber a) {
    }

    public boolean isValid(String value, ConstraintValidatorContext cvc) {
	if (value == null)
	    return true;
	// TODO реализовать проверку регистрационного номера АВТО
	return true;
    }

}