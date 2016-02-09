package kz.theeurasia.policy.validator;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidIdNumberConstraintValidator implements ConstraintValidator<ValidIdNumber, String> {

    private Pattern pattern;

    private static final String ID_NUMBER_PATTERN = "^[0-9]{12}?$";

    public void initialize(ValidIdNumber a) {
	pattern = Pattern.compile(ID_NUMBER_PATTERN);
    }

    public boolean isValid(String value, ConstraintValidatorContext cvc) {
	if (value == null)
	    return true;
	// TODO реализовать алгоритм проверки валидности ИИН
	return pattern.matcher(value.toString()).matches();
    }

}