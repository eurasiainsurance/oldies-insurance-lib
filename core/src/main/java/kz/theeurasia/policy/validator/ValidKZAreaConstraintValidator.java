package kz.theeurasia.policy.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lapsa.kz.country.KZArea;

public class ValidKZAreaConstraintValidator implements ConstraintValidator<ValidKZArea, KZArea> {

    private KZArea[] invalidTypes;

    @Override
    public void initialize(ValidKZArea constraintAnnotation) {
	this.invalidTypes = constraintAnnotation.invalidValues();
    }

    @Override
    public boolean isValid(KZArea value, ConstraintValidatorContext context) {
	if (value == null)
	    return true;
	for (KZArea i : invalidTypes)
	    if (i.equals(value))
		return false;
	return true;
    }

}