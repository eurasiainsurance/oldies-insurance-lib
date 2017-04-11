package com.lapsa.insurance.domain;

import java.time.LocalDate;

import com.lapsa.insurance.validation.DateLeftBeforeRight;
import com.lapsa.insurance.validation.LocalDateComparison;
import com.lapsa.insurance.validation.NotNullValue;

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
    private LocalDate from;

    @NotNullValue
    private LocalDate to;

    @DateLeftBeforeRight
    public LocalDateComparison comparisionFromAndTo() {
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
