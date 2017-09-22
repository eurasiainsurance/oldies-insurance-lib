package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

public enum CancelationReason implements InsuranceLocalizedElement {
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
	this.selectable = true;
    }

    private CancelationReason(boolean selectable) {
	this.selectable = selectable;
    }

    //

    private static final Predicate<CancelationReason> SELECTABLE_FILTER = CancelationReason::isSelectable;

    public static final CancelationReason[] selectableValues() {
	return Stream.of(values()) //
		.filter(SELECTABLE_FILTER) //
		.toArray(CancelationReason[]::new);
    }

    private static final Predicate<CancelationReason> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final CancelationReason[] nonSelectableValues() {
	return Stream.of(values()) //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(CancelationReason[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }
}
