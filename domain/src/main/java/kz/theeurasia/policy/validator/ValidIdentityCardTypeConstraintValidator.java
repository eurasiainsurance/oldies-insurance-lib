package kz.theeurasia.policy.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import kz.theeurasia.esbdproxy.domain.dict.general.IdentityCardTypeDict;

public class ValidIdentityCardTypeConstraintValidator
	implements ConstraintValidator<ValidIdentityCardType, IdentityCardTypeDict> {

    private IdentityCardTypeDict[] invalidValues;

    @Override
    public void initialize(ValidIdentityCardType constraintAnnotation) {
	this.invalidValues = constraintAnnotation.invalidValues();
    }

    @Override
    public boolean isValid(IdentityCardTypeDict value, ConstraintValidatorContext context) {
	if (value == null)
	    return true;
	for (IdentityCardTypeDict i : invalidValues)
	    if (i.equals(value))
		return false;
	return true;
    }

}