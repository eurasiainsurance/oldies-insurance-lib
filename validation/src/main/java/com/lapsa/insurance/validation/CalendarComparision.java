package com.lapsa.insurance.validation;

import java.util.Calendar;

public final class CalendarComparision implements TemporalComparison<Calendar> {

    private final Calendar left;
    private final Calendar right;

    public CalendarComparision(Calendar left, Calendar right) {
	this.left = left;
	this.right = right;
    }

    @Override
    public Calendar left() {
	return left;
    }

    @Override
    public Calendar right() {
	return right;
    }
}
