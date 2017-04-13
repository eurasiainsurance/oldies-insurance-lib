package com.lapsa.insurance.validation.validators;

import static com.lapsa.utils.TemporalUtils.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lapsa.insurance.validation.DateFuture;

public class DateFutureConstraintValidator implements ConstraintValidator<DateFuture, Object> {

    @Override
    public void initialize(DateFuture constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
	if (value == null)
	    return true;
	if (value instanceof Date)
	    return compare(toLocalDateTime((Date) value));
	if (value instanceof Calendar)
	    return compare(toLocalDateTime((Calendar) value));
	if (value instanceof LocalDate)
	    return compare(toLocalDateTime((LocalDate) value));
	if (value instanceof LocalDateTime)
	    return compare((LocalDateTime) value);
	return true;
    }

    private boolean compare(LocalDateTime value) {
	return value.isAfter(LocalDateTime.now());
    }
}
