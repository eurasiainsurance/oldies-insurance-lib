package kz.theeurasia.policy.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import kz.theeurasia.esbdproxy.domain.enums.osgpovts.InsuredExpirienceClassEnum;

public class ValidInsuranceExpirienceClassConstraintValidator
	implements ConstraintValidator<ValidInsuranceExpirienceClass, InsuredExpirienceClassEnum> {

    private InsuredExpirienceClassEnum[] invalidTypes;

    @Override
    public void initialize(ValidInsuranceExpirienceClass constraintAnnotation) {
	this.invalidTypes = constraintAnnotation.invalidValues();
    }

    @Override
    public boolean isValid(InsuredExpirienceClassEnum value, ConstraintValidatorContext context) {
	if (value == null)
	    return true;
	for (InsuredExpirienceClassEnum i : invalidTypes)
	    if (i.equals(value))
		return false;
	return true;
    }

}