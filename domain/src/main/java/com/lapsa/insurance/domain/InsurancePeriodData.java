package com.lapsa.insurance.domain;

import java.time.LocalDate;

import com.lapsa.validation.DateFuture;
import com.lapsa.validation.DateLeftBeforeRight;
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
    @DateFuture(allowNow = true)
    private LocalDate from;

    @NotNullValue
    @DateFuture
    private LocalDate to;

    @DateLeftBeforeRight
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
