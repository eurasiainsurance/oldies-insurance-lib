package kz.theeurasia.policy.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotNullValueConstraintValidator implements ConstraintValidator<NotNullValue, Object> {

    @Override
    public void initialize(NotNullValue constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
	return value != null;
    }

}