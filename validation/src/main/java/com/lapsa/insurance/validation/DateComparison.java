package com.lapsa.insurance.validation;

import java.util.Date;

public final class DateComparision implements TemporalComparison<Date> {

    private final Date left;
    private final Date right;

    public DateComparision(Date left, Date right) {
	this.left = left;
	this.right = right;
    }

    @Override
    public Date left() {
	return left;
    }

    @Override
    public Date right() {
	return right;
    }
}
