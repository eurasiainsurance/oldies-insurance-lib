package com.lapsa.insurance.validation.validators;

import static com.lapsa.insurance.validation.validators.TemporalUtil.*;

import java.lang.annotation.Annotation;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lapsa.insurance.validation.CalendarComparision;
import com.lapsa.insurance.validation.DateComparision;
import com.lapsa.insurance.validation.LocalDateComparision;
import com.lapsa.insurance.validation.LocalDateTimeComparision;
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

	if (value instanceof CalendarComparision)
	    return compare((CalendarComparision) value);

	if (value instanceof DateComparision)
	    return compare((DateComparision) value);

	if (value instanceof LocalDateComparision)
	    return compare((LocalDateComparision) value);

	if (value instanceof LocalDateTimeComparision)
	    return compare((LocalDateTimeComparision) value);

	return true;
    }

    private boolean compare(LocalDateTimeComparision value) {
	return compare(value.left(), value.right());
    }

    private boolean compare(LocalDateComparision value) {
	return compare(value.left(), value.right());
    }

    private boolean compare(DateComparision value) {
	return compare(toLocalDateTime(value.left()), toLocalDateTime(value.right()));
    }

    private boolean compare(CalendarComparision value) {
	return compare(toLocalDateTime(value.left()), toLocalDateTime(value.right()));
    }

    protected abstract boolean compare(LocalDateTime left, LocalDateTime right);

    protected abstract boolean compare(LocalDate left, LocalDate right);
}
