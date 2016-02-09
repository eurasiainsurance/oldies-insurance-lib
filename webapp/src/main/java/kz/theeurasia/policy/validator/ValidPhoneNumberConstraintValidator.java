package kz.theeurasia.policy.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidPhoneNumberConstraintValidator implements ConstraintValidator<ValidPhoneNumber, String> {

    public void initialize(ValidPhoneNumber a) {
    }

    public boolean isValid(String value, ConstraintValidatorContext cvc) {
	if (value == null)
	    return true;
	// TODO реализовать проверку номера телефона
	return true;
    }

}