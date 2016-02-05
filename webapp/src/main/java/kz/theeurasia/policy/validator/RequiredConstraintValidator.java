package kz.theeurasia.policy.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RequiredConstraintValidator implements ConstraintValidator<Required, String> {

    private boolean trimSpaces;

    public void initialize(Required a) {
	this.trimSpaces = a.trimSpaces();
    }

    public boolean isValid(String value, ConstraintValidatorContext cvc) {
	boolean res = value != null;
	if (trimSpaces)
	    res = res && !value.trim().isEmpty();
	else
	    res = res && !value.isEmpty();
	return res;
    }

}