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
	if (!pattern.matcher(value.toString()).matches())
	    return false;
	return validIIN(value);
    }

    /**
     * 5. Алгоритм расчета значения контрольного разряда
     * 
     * В целях осуществления контроля и снижения ошибок клавиатурного ввода в
     * составе ИИН (БИН) предусматривается наличие контрольного 12-го разряда,
     * при расчете которого будет использоваться следующий алгоритм в два цикла:
     * 
     * а12=(а1*b1+а2*b2+а3*b3+а4*b4+а5*b5+а6*b6+а7*b7+а8*b8+а9*b9+a10*b10+a11*
     * b11) mod 11,
     * 
     * где: ai - значение i-гo разряда;
     * 
     * bi - вес i-гo разряда.
     * 
     * разряд ИИН: 1 2 3 4 5 6 7 8 9 10 11
     * 
     * вес разряда: 1 2 3 4 5 6 7 8 9 10 11.
     * 
     * 1. Если полученное число равно 10, то расчет контрольного разряда
     * производится с другой последовательностью весов:
     * 
     * разряд ИИН: 1 2 3 4 5 6 7 8 9 10 11
     * 
     * вес разряда: 3 4 5 6 7 8 9 10 11 1 2.
     * 
     * 2. Если полученное число также равно 10, то данный ИИН не используется.
     * 
     * 3. Если полученное число имеет значение от 0 до 9, то данное число
     * берется в качестве контрольного разряда.
     */
    private static byte[][] weights = new byte[][] {
	    new byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 },
	    new byte[] { 3, 4, 5, 6, 7, 8, 9, 10, 11, 1, 2 } };

    private static boolean validIIN(String value) {
	byte[] iin = new byte[12];
	for (int i = 0; i < 12; i++)
	    iin[i] = Byte.parseByte(Character.toString(value.charAt(i)));
	for (byte[] w : weights) {
	    int control = 0;
	    for (int i = 0; i < 11; i++)
		control += iin[i] * w[i];
	    control = control % 11;
	    if (control < 10)
		return control == iin[11];
	}
	return false;
    }
}