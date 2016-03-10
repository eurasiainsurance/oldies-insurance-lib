package kz.theeurasia.policy.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lapsa.country.Country;

public class ValidCountryConstraintValidator
	implements ConstraintValidator<ValidCountry, Country> {

    private Country[] invalidTypes;

    @Override
    public void initialize(ValidCountry constraintAnnotation) {
	this.invalidTypes = constraintAnnotation.invalidValues();
    }

    @Override
    public boolean isValid(Country value, ConstraintValidatorContext context) {
	if (value == null)
	    return true;
	for (Country i : invalidTypes)
	    if (i.equals(value))
		return false;
	return true;
    }

}