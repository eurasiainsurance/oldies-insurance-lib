package kz.theeurasia.policy.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lapsa.insurance.elements.VehicleClass;

public class ValidVehicleClassConstraintValidator
	implements ConstraintValidator<ValidVehicleClass, VehicleClass> {

    private VehicleClass[] invalidTypes;

    @Override
    public void initialize(ValidVehicleClass constraintAnnotation) {
	this.invalidTypes = constraintAnnotation.invalidValues();
    }

    @Override
    public boolean isValid(VehicleClass value, ConstraintValidatorContext context) {
	if (value == null)
	    return true;
	for (VehicleClass i : invalidTypes)
	    if (i.equals(value))
		return false;
	return true;
    }

}