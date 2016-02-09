package kz.theeurasia.policy.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidURLConstraintValidator implements ConstraintValidator<ValidURL, String> {

    @Override
    public void initialize(ValidURL a) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext cvc) {
	if (value == null)
	    return true;
	// TODO реализовать проверку адреса сайта
	return true;
    }

}