package com.lapsa.insurance.domain;

import static com.lapsa.insurance.domain.DisplayNameElements.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Optional;
import java.util.StringJoiner;

import com.lapsa.validation.LocalDateComparison;
import com.lapsa.validation.NotNullValue;
import com.lapsa.validation.TemporalFuture;
import com.lapsa.validation.TemporalLeftBeforeRight;

public class InsurancePeriodData extends BaseDomain {
    private static final long serialVersionUID = 5019017773831664143L;
    private static final int PRIME = 179;
    private static final int MULTIPLIER = PRIME;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

    @NotNullValue
    @TemporalFuture(allowNow = true)
    private LocalDate from;

    @NotNullValue
    @TemporalFuture
    private LocalDate to;

    @Override
    public String displayName(DisplayNameVariant variant, Locale locale) {
	StringBuilder sb = new StringBuilder();

	sb.append(INSURANCE_PERIOD_DATA.displayName(variant, locale));

	StringJoiner sj = new StringJoiner(", ", " ", "");
	sj.setEmptyValue("");

	Optional.ofNullable(from) //
		.map(DateTimeFormatter.ISO_LOCAL_DATE::format)
		.map(x -> INSURANCE_PERIOD_DATA_FROM.displayName(variant, locale) + " " + x)
		.ifPresent(sj::add);

	Optional.ofNullable(to) //
		.map(DateTimeFormatter.ISO_LOCAL_DATE::format)
		.map(x -> INSURANCE_PERIOD_DATA_TILL.displayName(variant, locale) + " " + x)
		.ifPresent(sj::add);

	return sb.append(sj.toString()) //
		.toString();
    }

    @TemporalLeftBeforeRight
    // method must be a getter (name begins with "get"). validation is not
    // processed if not
    public LocalDateComparison getComparision() {
	return new LocalDateComparison(from, to);
    }

    public LocalDate getFrom() {
	return from;
    }

    public void setFrom(LocalDate from) {
	this.from = from;
    }

    public LocalDate getTo() {
	return to;
    }

    public void setTo(LocalDate to) {
	this.to = to;
    }
}
