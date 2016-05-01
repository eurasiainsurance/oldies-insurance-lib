package kz.theeurasia.policy.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lapsa.insurance.elements.VehicleAgeClass;

public class ValidVehicleAgeClassConstraintValidator
	implements ConstraintValidator<ValidVehicleAgeClass, VehicleAgeClass> {

    private VehicleAgeClass[] invalidTypes;

    @Override
    public void initialize(ValidVehicleAgeClass constraintAnnotation) {
	this.invalidTypes = constraintAnnotation.invalidValues();
    }

    @Override
    public boolean isValid(VehicleAgeClass value, ConstraintValidatorContext context) {
	if (value == null)
	    return true;
	for (VehicleAgeClass i : invalidTypes)
	    if (i.equals(value))
		return false;
	return true;
    }

}