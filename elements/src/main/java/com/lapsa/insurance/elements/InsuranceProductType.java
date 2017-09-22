package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

public enum InsuranceProductType implements InsuranceLocalizedElement {
    POLICY, // Полис ОС ГПО ВТС
    CASCO, // Авто КАСКО
    ;

    //

    private final boolean selectable;

    //

    private InsuranceProductType() {
	this.selectable = true;
    }

    private InsuranceProductType(boolean selectable) {
	this.selectable = selectable;
    }

    //

    private static final Predicate<InsuranceProductType> SELECTABLE_FILTER = InsuranceProductType::isSelectable;

    public static final InsuranceProductType[] selectableValues() {
	return Stream.of(values()) //
		.filter(SELECTABLE_FILTER) //
		.toArray(InsuranceProductType[]::new);
    }

    private static final Predicate<InsuranceProductType> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final InsuranceProductType[] nonSelectableValues() {
	return Stream.of(values()) //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(InsuranceProductType[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }
}
