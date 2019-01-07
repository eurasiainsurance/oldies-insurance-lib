package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

import tech.lapsa.java.commons.localization.LocalizedElement;

public enum InsuranceRequestStatus implements LocalizedElement {
    PENDING, // На обработке
    POLICY_ISSUED, // Полис выпущен
    PREMIUM_PAID, // Премиия оплачена
    REQUEST_CANCELED, // Заявка отменена
    ;

    //

    private final boolean selectable;

    //

    private InsuranceRequestStatus() {
	selectable = true;
    }

    private InsuranceRequestStatus(final boolean selectable) {
	this.selectable = selectable;
    }

    //

    public static final Stream<InsuranceRequestStatus> valuesStream() {
	return Stream.of(values());
    }

    //

    private static final Predicate<InsuranceRequestStatus> SELECTABLE_FILTER = InsuranceRequestStatus::isSelectable;

    public static final InsuranceRequestStatus[] selectableValues() {
	return valuesStream() //
		.filter(SELECTABLE_FILTER) //
		.toArray(InsuranceRequestStatus[]::new);
    }

    private static final Predicate<InsuranceRequestStatus> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final InsuranceRequestStatus[] nonSelectableValues() {
	return valuesStream() //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(InsuranceRequestStatus[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }
}
