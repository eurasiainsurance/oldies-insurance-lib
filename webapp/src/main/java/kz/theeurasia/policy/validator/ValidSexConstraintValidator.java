package kz.theeurasia.policy.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import kz.theeurasia.esbdproxy.domain.dict.general.SexDict;

public class ValidSexConstraintValidator
	implements ConstraintValidator<ValidSex, SexDict> {

    private SexDict[] invalidTypes;

    @Override
    public void initialize(ValidSex constraintAnnotation) {
	this.invalidTypes = constraintAnnotation.invalidValues();
    }

    @Override
    public boolean isValid(SexDict value, ConstraintValidatorContext context) {
	if (value == null)
	    return true;
	for (SexDict i : invalidTypes)
	    if (i.equals(value))
		return false;
	return true;
    }

}