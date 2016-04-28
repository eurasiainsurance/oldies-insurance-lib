package kz.theeurasia.policy.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import kz.theeurasia.esbdproxy.domain.dict.osgpovts.VehicleClassDict;

public class ValidVehicleClassConstraintValidator
	implements ConstraintValidator<ValidVehicleClass, VehicleClassDict> {

    private VehicleClassDict[] invalidTypes;

    @Override
    public void initialize(ValidVehicleClass constraintAnnotation) {
	this.invalidTypes = constraintAnnotation.invalidValues();
    }

    @Override
    public boolean isValid(VehicleClassDict value, ConstraintValidatorContext context) {
	if (value == null)
	    return true;
	for (VehicleClassDict i : invalidTypes)
	    if (i.equals(value))
		return false;
	return true;
    }

}