package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

import tech.lapsa.java.commons.localization.LocalizedElement;

public enum CancelationReason implements LocalizedElement {
    CANCELATION_AND_RENEW, // Досрочное прекращение договора и заключение
			   // нового
    CANCELATION, // Досрочное расторжение
    MADE_INSURANCE_PAYMENT, // Произведена страховая выплата
    PREMIUM_COST_ERROR, // Корректировка неверно рассчитанной премии
    POLICY_LOST, // Утеря
    ISSUED_DUPLICATE_POLICY, // Выпущен дубликат
    OTHER, // Другая причина
    HUMAN_FAILURE, // Ошибка оператора
    ;

    //

    private final boolean selectable;

    //

    private CancelationReason() {
	selectable = true;
    }

    private CancelationReason(final boolean selectable) {
	this.selectable = selectable;
    }

    //

    public static final Stream<CancelationReason> valuesStream() {
	return Stream.of(values());
    }

    //

    private static final Predicate<CancelationReason> SELECTABLE_FILTER = CancelationReason::isSelectable;

    public static final CancelationReason[] selectableValues() {
	return valuesStream() //
		.filter(SELECTABLE_FILTER) //
		.toArray(CancelationReason[]::new);
    }

    private static final Predicate<CancelationReason> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final CancelationReason[] nonSelectableValues() {
	return valuesStream() //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(CancelationReason[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }
}
