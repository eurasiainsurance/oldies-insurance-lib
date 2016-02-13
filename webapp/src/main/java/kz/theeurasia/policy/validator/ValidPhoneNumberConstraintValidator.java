package kz.theeurasia.policy.validator;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidPhoneNumberConstraintValidator implements ConstraintValidator<ValidPhoneNumber, String> {

    private Pattern pattern;

    private static final String PHONE_NUMBER_PATTERN = "^\\+7 \\(\\d\\d\\d\\) \\d\\d\\d\\-\\d\\d\\-\\d\\d?$";

    @Override
    public void initialize(ValidPhoneNumber a) {
	pattern = Pattern.compile(PHONE_NUMBER_PATTERN);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext cvc) {
	if (value == null)
	    return true;
	return pattern.matcher(value.toString()).matches();
    }

}