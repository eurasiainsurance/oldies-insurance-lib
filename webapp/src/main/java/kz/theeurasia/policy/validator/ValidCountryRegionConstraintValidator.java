package kz.theeurasia.policy.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import kz.theeurasia.esbdproxy.domain.dict.general.CountryRegionDict;

public class ValidCountryRegionConstraintValidator
	implements ConstraintValidator<ValidCountryRegion, CountryRegionDict> {

    private CountryRegionDict[] invalidTypes;

    @Override
    public void initialize(ValidCountryRegion constraintAnnotation) {
	this.invalidTypes = constraintAnnotation.invalidValues();
    }

    @Override
    public boolean isValid(CountryRegionDict value, ConstraintValidatorContext context) {
	if (value == null)
	    return true;
	for (CountryRegionDict i : invalidTypes)
	    if (i.equals(value))
		return false;
	return true;
    }

}