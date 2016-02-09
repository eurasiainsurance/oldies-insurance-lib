package kz.theeurasia.policy.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import kz.theeurasia.esbdproxy.domain.enums.osgpovts.InsuredAgeClassEnum;

public class ValidInsuranceAgeClassConstraintValidator
	implements ConstraintValidator<ValidInsuranceAgeClass, InsuredAgeClassEnum> {

    private InsuredAgeClassEnum[] invalidTypes;

    @Override
    public void initialize(ValidInsuranceAgeClass constraintAnnotation) {
	this.invalidTypes = constraintAnnotation.invalidValues();
    }

    @Override
    public boolean isValid(InsuredAgeClassEnum value, ConstraintValidatorContext context) {
	if (value == null)
	    return true;
	for (InsuredAgeClassEnum i : invalidTypes)
	    if (i.equals(value))
		return false;
	return true;
    }

}