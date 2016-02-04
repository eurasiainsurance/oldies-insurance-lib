package kz.theeurasia.policy.validator;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class VinCodeConstraintValidator implements ConstraintValidator<VinCode, String> {

    private static final String VIN_CODE_PATTERN = "^[0123456789ABCDEFGHJKLMNPRSTUVWXYZ]{12}$";
    private Pattern pattern;

    @Override
    public void initialize(VinCode constraintAnnotation) {
	pattern = Pattern.compile(VIN_CODE_PATTERN);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
	if (value == null)
	    return true;
	return pattern.matcher(value).matches();
    }

}
