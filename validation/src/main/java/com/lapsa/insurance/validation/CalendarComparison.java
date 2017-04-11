package com.lapsa.insurance.validation;

import java.util.Calendar;

public final class CalendarComparison implements TemporalComparison<Calendar> {

    private final Calendar left;
    private final Calendar right;

    public CalendarComparison(Calendar left, Calendar right) {
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
