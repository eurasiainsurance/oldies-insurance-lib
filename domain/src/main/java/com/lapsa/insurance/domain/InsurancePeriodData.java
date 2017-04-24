package com.lapsa.insurance.domain;

import java.time.LocalDate;

import com.lapsa.validation.TemporalFuture;
import com.lapsa.validation.TemporalLeftBeforeRight;
import com.lapsa.validation.LocalDateComparison;
import com.lapsa.validation.NotNullValue;

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
