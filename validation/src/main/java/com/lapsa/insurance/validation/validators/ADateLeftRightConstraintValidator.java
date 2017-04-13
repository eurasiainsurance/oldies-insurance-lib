package com.lapsa.insurance.validation.validators;

import static com.lapsa.utils.TemporalUtils.*;

import java.lang.annotation.Annotation;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lapsa.insurance.validation.CalendarComparison;
import com.lapsa.insurance.validation.DateComparison;
import com.lapsa.insurance.validation.LocalDateComparison;
import com.lapsa.insurance.validation.LocalDateTimeComparison;
import com.lapsa.insurance.validation.TemporalComparison;

public abstract class ADateLeftRightConstraintValidator<A extends Annotation>
	implements ConstraintValidator<A, TemporalComparison<?>> {

    @Override
    public void initialize(A constraintAnnotation) {
    }

    @Override
    public boolean isValid(TemporalComparison<?> value, ConstraintValidatorContext context) {
	if (value == null)
	    return true;

	if (value instanceof CalendarComparison)
	    return compare((CalendarComparison) value);

	if (value instanceof DateComparison)
	    return compare((DateComparison) value);

	if (value instanceof LocalDateComparison)
	    return compare((LocalDateComparison) value);

	if (value instanceof LocalDateTimeComparison)
	    return compare((LocalDateTimeComparison) value);

	return true;
    }

    private boolean compare(LocalDateTimeComparison value) {
	return compare(value.left(), value.right());
    }

    private boolean compare(LocalDateComparison value) {
	return compare(value.left(), value.right());
    }

    private boolean compare(DateComparison value) {
	return compare(toLocalDateTime(value.left()), toLocalDateTime(value.right()));
    }

    private boolean compare(CalendarComparison value) {
	return compare(toLocalDateTime(value.left()), toLocalDateTime(value.right()));
    }

    protected abstract boolean compare(LocalDateTime left, LocalDateTime right);

    protected abstract boolean compare(LocalDate left, LocalDate right);
}
