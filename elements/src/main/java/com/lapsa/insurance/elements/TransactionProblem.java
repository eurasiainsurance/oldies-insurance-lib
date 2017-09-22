package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

public enum TransactionProblem implements InsuranceLocalizedElement {
    CANCELED_BY_CONSUMER, //
    WRONG_DATA_PROVIDED, //
    TEST, //
    DUPLICATE,
    OTHER, //
    ;

    //

    private final boolean selectable;

    //

    private TransactionProblem() {
	this.selectable = true;
    }

    private TransactionProblem(boolean selectable) {
	this.selectable = selectable;
    }

    //

    private static final Predicate<TransactionProblem> SELECTABLE_FILTER = TransactionProblem::isSelectable;

    public static final TransactionProblem[] selectableValues() {
	return Stream.of(values()) //
		.filter(SELECTABLE_FILTER) //
		.toArray(TransactionProblem[]::new);
    }

    private static final Predicate<TransactionProblem> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final TransactionProblem[] nonSelectableValues() {
	return Stream.of(values()) //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(TransactionProblem[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }
}
