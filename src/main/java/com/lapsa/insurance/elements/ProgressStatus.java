package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

import tech.lapsa.java.commons.localization.LocalizedElement;

public enum ProgressStatus implements LocalizedElement {
    NEW, //
    ON_PROCESS, //
    ON_HOLD, //
    FINISHED, //
    ;

    //

    private final boolean selectable;

    //

    private ProgressStatus() {
	selectable = true;
    }

    private ProgressStatus(final boolean selectable) {
	this.selectable = selectable;
    }

    //

    public static final Stream<ProgressStatus> valuesStream() {
	return Stream.of(values());
    }

    //

    private static final Predicate<ProgressStatus> SELECTABLE_FILTER = ProgressStatus::isSelectable;

    public static final ProgressStatus[] selectableValues() {
	return valuesStream() //
		.filter(SELECTABLE_FILTER) //
		.toArray(ProgressStatus[]::new);
    }

    private static final Predicate<ProgressStatus> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final ProgressStatus[] nonSelectableValues() {
	return valuesStream() //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(ProgressStatus[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }
}
