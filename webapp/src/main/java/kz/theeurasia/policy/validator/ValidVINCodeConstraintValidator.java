package kz.theeurasia.policy.validator;

import java.util.Locale;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidVINCodeConstraintValidator implements ConstraintValidator<ValidVINCode, String> {

    private static final String VIN_CODE_PATTERN = "^[0123456789ABCDEFGHJKLMNPRSTUVWXYZ]{17}$";
    private Pattern pattern;
    private boolean checkDigit;
    private boolean caseSensitive;

    @Override
    public void initialize(ValidVINCode constraintAnnotation) {
	checkDigit = constraintAnnotation.checkDigit();
	caseSensitive = constraintAnnotation.caseSensitive();
	if (caseSensitive)
	    pattern = Pattern.compile(VIN_CODE_PATTERN);
	else
	    pattern = Pattern.compile(VIN_CODE_PATTERN, Pattern.CASE_INSENSITIVE);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
	if (value == null)
	    return true;
	if (!pattern.matcher(value).matches())
	    return false;
	if (!checkDigit)
	    return true;
	if (!caseSensitive)
	    return checkDigit(value.toUpperCase(Locale.ENGLISH));
	return checkDigit(value);
    }

    /*
     * Стандарт ISO 3779, оговаривающий структуру VIN транспортного средства,
     * рекомендует в 9-о позиции VIN размещать контрольную сумму (контрольное
     * число, проверочное число) - число, вычисленное по определенному
     * стандартом алгоритму, чье значение зависит от значений всех остальных
     * знаков в VIN. Контрольная сумма позволяет противодействовать легализации
     * автомобилей с перебитыми номерами автоворам (изменение любого из знаков в
     * VIN приводит к изменению контрольной суммы, но ее, как правило угонщики
     * не пересчитывают) и вычислять ошибочные номера кузовов при ручном
     * внесении их в базы данных. Обязательным выполнение стандарта в этой части
     * является только в США и Канаде. Поэтому все автомобили, предназначенные
     * для реализации на североамериканском континенте, в 9-ой позиции в
     * обязательном порядке содержат контрольную сумму, которою можно проверить
     * на этой странице. В Европе эта рекомендация стандарта не является
     * обязательной и поэтому производители, как правило, или используют 9-ую
     * позицию для обозначения какой-то дополнительной характеристики автомобиля
     * или ставят туда фиксированный знак: "0" (очень популярен у японских
     * производителей) или "Z" (Volkswagen, Audi). Но есть и исключения -
     * автомобили BMW имеют идентичную структуру VIN независимо от рынка сбыта.
     * 
     * В случае использования в 9-ой позиции контрольной суммы там допустимы
     * следующие значения: числа 0...9 или X. Если в 9-ой позиции находится
     * любой другой знак, то такой VIN не пройдет проверку. Если это VIN
     * автомобиля, предназначенного для североамериканского рынка, то он или
     * переписан с автомобиля с ошибками или перебит.
     * 
     * Но необходимо учитывать тот факт, что если VIN содержит контрольную
     * сумму, но автомобиль был собран из SKD комплекта (особенно актуально для
     * "отверточной сборки в странах СНГ), то VIN, нанесенный на кузов,
     * становится просто номером кузова, а завод-сборщик присваивает свой новый
     * VIN, который и наносит на дополнительной табличке на кузове. При этом,
     * чаще всего, происходит замена WMI (идентификационного кода
     * завода-изготовителя) в " старом " VIN на код этого сборщика и остальные
     * знаки с 4 по 17-ый переносятся без изменений. Поэтому в таких VIN
     * контрольная сумма уже не будет считаться корректно - надо брать " старый"
     * VIN и проверять его.
     * 
     * Пример расчета контрольной суммы: 1. БеремVIN, например
     * JHMCM56557C404453, и заполняем табличку ниже:
     * 
     * Позиция VIN 1 2 3 4 5 6 7 8 CHK 10 11 12 13 14 15 16 17 VIN J H M C M 5 6
     * * 5 5 7 C 4 0 4 4 5 3 2. Подменяем буквы на цифры в соответствии с *
     * таблицей:
     * 
     * Буква A B C D E F G H J K L M N P R S T U V W X Y Z Цифровой эквивалент 1
     * 2 3 4 5 6 7 8 1 2 3 4 5 7 9 2 3 4 5 6 7 8 9 3. И заполняем таблицу ниже,
     * где для каждого знака VIN указан его "вес":
     * 
     * Позиция VIN 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 Вес 8 7 6 5 4 3 2
     * 10 CHK 9 8 7 6 5 4 3 2 Цифровой эквивалент 1 8 4 3 4 5 6 5 CHK 7 3 4 0 4
     * 4 5 3 4. Складываем произведения каждого знака VIN на его "вес": 1*8 +
     * 8*7 + 4*6 + 3*5 + 4*4 + 5*3 + 6*2 + 5*10 + 7*9 + 3*8 + 4*7 + 0*6 + 4*5 +
     * 4*4 + 5*3 + 3*2 = 368
     * 
     * 5. Вычисляем ближайшее наименьшее целое число, кратное 11: 368/11 = 33.5
     * 33 * 11 = 363
     * 
     * 6. Разницу между результатом в п. 5 и ближайшим наименьшим числом,
     * кратным 11 записывается в десятый знак VIN: CHK = 368 - 363 = 5 Если CHK
     * = 10, то в 9-ой позиции VIN записывается "X" (римская 10).
     * 
     * Взято отсюда http://carinfo.kiev.ua/cars/vin/chksum
     */

    private final static char[] chars = new char[] {
	    'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'R', 'S',
	    'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    private final static byte[] conversionTable = new byte[] {
	    1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5, 7, 9, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

    private final static byte[] weight = new byte[] {
	    8, 7, 6, 5, 4, 3, 2, 10, -1, 9, 8, 7, 6, 5, 4, 3, 2 };

    private boolean checkDigit(String value) {
	char[] vin = new char[17];
	byte[] convertedVin = new byte[17];
	for (int i = 0; i < 17; i++) {
	    vin[i] = value.charAt(i);
	    boolean conversionValuefound = false;
	    for (int idx = 0; idx < chars.length; idx++) {
		if (vin[i] == chars[idx]) {
		    convertedVin[i] = conversionTable[idx];
		    conversionValuefound = true;
		    break;
		}
	    }
	    if (!conversionValuefound)
		return false;
	}

	int control = 0;
	for (int i = 0; i < 17; i++) {
	    if (i == 8) // control number bypassing
		continue;
	    control += convertedVin[i] * weight[i];
	}
	control = control % 11;
	char controlChar = control == 10 ? 'X' : Character.forDigit(control, 10);
	return vin[8] == controlChar;
    }
}
