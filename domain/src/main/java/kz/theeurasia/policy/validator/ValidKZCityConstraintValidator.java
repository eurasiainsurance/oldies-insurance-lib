package kz.theeurasia.policy.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lapsa.kz.country.KZCity;

public class ValidKZCityConstraintValidator implements ConstraintValidator<ValidKZCity, KZCity> {

    private KZCity[] invalidTypes;

    @Override
    public void initialize(ValidKZCity constraintAnnotation) {
	this.invalidTypes = constraintAnnotation.invalidValues();
    }

    @Override
    public boolean isValid(KZCity value, ConstraintValidatorContext context) {
	if (value == null)
	    return true;
	for (KZCity i : invalidTypes)
	    if (i.equals(value))
		return false;
	return true;
    }

}