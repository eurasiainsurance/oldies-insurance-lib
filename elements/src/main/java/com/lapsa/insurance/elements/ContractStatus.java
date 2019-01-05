package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

import tech.lapsa.java.commons.localization.LocalizedElement;

public enum ContractStatus implements LocalizedElement {
    COMPLETED, // Сделка состоялась
    CANCELED, // Сделка не состоялась
    ;

    //

    private final boolean selectable;

    //

    private ContractStatus() {
	selectable = true;
    }

    private ContractStatus(final boolean selectable) {
	this.selectable = selectable;
    }

    //

    public static final Stream<ContractStatus> valuesStream() {
	return Stream.of(values());
    }

    //

    private static final Predicate<ContractStatus> SELECTABLE_FILTER = ContractStatus::isSelectable;

    public static final ContractStatus[] selectableValues() {
	return valuesStream() //
		.filter(SELECTABLE_FILTER) //
		.toArray(ContractStatus[]::new);
    }

    private static final Predicate<ContractStatus> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final ContractStatus[] nonSelectableValues() {
	return valuesStream() //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(ContractStatus[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }
}
