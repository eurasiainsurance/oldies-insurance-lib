package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

public enum WhoIsInsurant implements InsuranceLocalizedElement {
    DRIVER, // Страхователем является один из застрахованных водителей
    OTHER, // Страхователем является другое лицо
    ;

    //

    private final boolean selectable;

    //

    private WhoIsInsurant() {
	this.selectable = true;
    }

    private WhoIsInsurant(boolean selectable) {
	this.selectable = selectable;
    }

    //

    private static final Predicate<WhoIsInsurant> SELECTABLE_FILTER = WhoIsInsurant::isSelectable;

    public static final WhoIsInsurant[] selectableValues() {
	return Stream.of(values()) //
		.filter(SELECTABLE_FILTER) //
		.toArray(WhoIsInsurant[]::new);
    }

    private static final Predicate<WhoIsInsurant> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final WhoIsInsurant[] nonSelectableValues() {
	return Stream.of(values()) //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(WhoIsInsurant[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }
}
