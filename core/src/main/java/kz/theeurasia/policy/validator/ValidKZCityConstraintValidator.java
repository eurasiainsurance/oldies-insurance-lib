package kz.theeurasia.policy.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import kz.theeurasia.esbdproxy.domain.dict.general.KZCityDict;

public class ValidKZCityConstraintValidator
	implements ConstraintValidator<ValidKZCity, KZCityDict> {

    private KZCityDict[] invalidTypes;

    @Override
    public void initialize(ValidKZCity constraintAnnotation) {
	this.invalidTypes = constraintAnnotation.invalidValues();
    }

    @Override
    public boolean isValid(KZCityDict value, ConstraintValidatorContext context) {
	if (value == null)
	    return true;
	for (KZCityDict i : invalidTypes)
	    if (i.equals(value))
		return false;
	return true;
    }

}