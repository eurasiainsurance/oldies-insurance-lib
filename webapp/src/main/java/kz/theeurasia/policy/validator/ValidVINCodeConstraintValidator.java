package kz.theeurasia.policy.validator;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidVINCodeConstraintValidator implements ConstraintValidator<ValidVINCode, String> {

    private static final String VIN_CODE_PATTERN = "^[0123456789ABCDEFGHJKLMNPRSTUVWXYZ]{17}$";
    private Pattern pattern;

    @Override
    public void initialize(ValidVINCode constraintAnnotation) {
	pattern = Pattern.compile(VIN_CODE_PATTERN, Pattern.CASE_INSENSITIVE);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
	if (value == null)
	    return true;
	// TODO реализовать проверку VIN-кода
	return pattern.matcher(value).matches();
    }
}
