package kz.theeurasia.policy.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import kz.theeurasia.esbdproxy.domain.dict.general.CountryDict;

public class ValidCountryConstraintValidator
	implements ConstraintValidator<ValidCountry, CountryDict> {

    private CountryDict[] invalidTypes;

    @Override
    public void initialize(ValidCountry constraintAnnotation) {
	this.invalidTypes = constraintAnnotation.invalidValues();
    }

    @Override
    public boolean isValid(CountryDict value, ConstraintValidatorContext context) {
	if (value == null)
	    return true;
	for (CountryDict i : invalidTypes)
	    if (i.equals(value))
		return false;
	return true;
    }

}