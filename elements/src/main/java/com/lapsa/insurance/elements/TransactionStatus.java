package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

public enum TransactionStatus implements InsuranceLocalizedElement {
    COMPLETED, // Сделка состоялась
    NOT_COMPLETED, // Сделка не состоялась
    ;

    //

    private final boolean selectable;

    //

    private TransactionStatus() {
	this.selectable = true;
    }

    private TransactionStatus(boolean selectable) {
	this.selectable = selectable;
    }

    //

    private static final Predicate<TransactionStatus> SELECTABLE_FILTER = TransactionStatus::isSelectable;

    public static final TransactionStatus[] selectableValues() {
	return Stream.of(values()) //
		.filter(SELECTABLE_FILTER) //
		.toArray(TransactionStatus[]::new);
    }

    private static final Predicate<TransactionStatus> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final TransactionStatus[] nonSelectableValues() {
	return Stream.of(values()) //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(TransactionStatus[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }
}
