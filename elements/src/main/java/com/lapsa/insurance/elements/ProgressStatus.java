package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

public enum ProgressStatus implements InsuranceLocalizedElement {
    NEW, //
    ON_PROCESS, //
    ON_HOLD, //
    FINISHED, //
    ;

    //

    private final boolean selectable;

    //

    private ProgressStatus() {
	this.selectable = true;
    }

    private ProgressStatus(boolean selectable) {
	this.selectable = selectable;
    }

    //

    private static final Predicate<ProgressStatus> SELECTABLE_FILTER = ProgressStatus::isSelectable;

    public static final ProgressStatus[] selectableValues() {
	return Stream.of(values()) //
		.filter(SELECTABLE_FILTER) //
		.toArray(ProgressStatus[]::new);
    }

    private static final Predicate<ProgressStatus> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final ProgressStatus[] nonSelectableValues() {
	return Stream.of(values()) //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(ProgressStatus[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }
}
