package kz.theeurasia.policy.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import kz.theeurasia.esbdproxy.domain.dict.osgpovts.VehicleAgeClassDict;

public class ValidVehicleAgeClassConstraintValidator
	implements ConstraintValidator<ValidVehicleAgeClass, VehicleAgeClassDict> {

    private VehicleAgeClassDict[] invalidTypes;

    @Override
    public void initialize(ValidVehicleAgeClass constraintAnnotation) {
	this.invalidTypes = constraintAnnotation.invalidValues();
    }

    @Override
    public boolean isValid(VehicleAgeClassDict value, ConstraintValidatorContext context) {
	if (value == null)
	    return true;
	for (VehicleAgeClassDict i : invalidTypes)
	    if (i.equals(value))
		return false;
	return true;
    }

}