package com.lapsa.insurance.validation;

import java.time.LocalDateTime;

public final class LocalDateTimeComparision implements TemporalComparison<LocalDateTime> {

    private final LocalDateTime left;
    private final LocalDateTime right;

    public LocalDateTimeComparision(LocalDateTime left, LocalDateTime right) {
	this.left = left;
	this.right = right;
    }

    @Override
    public LocalDateTime left() {
	return left;
    }

    @Override
    public LocalDateTime right() {
	return right;
    }
}
