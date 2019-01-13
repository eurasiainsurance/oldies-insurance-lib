package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

import tech.lapsa.java.commons.localization.LocalizedElement;

public enum InsuranceProductType implements LocalizedElement {
    POLICY, // Полис ОС ГПО ВТС
    CASCO, // Авто КАСКО
    UNKNOWN, // неизвестный
    ;

    //

    private final boolean selectable;

    //

    private InsuranceProductType() {
	selectable = true;
    }

    private InsuranceProductType(final boolean selectable) {
	this.selectable = selectable;
    }

    //

    public static final Stream<InsuranceProductType> valuesStream() {
	return Stream.of(values());
    }

    //

    private static final Predicate<InsuranceProductType> SELECTABLE_FILTER = InsuranceProductType::isSelectable;

    public static final InsuranceProductType[] selectableValues() {
	return valuesStream() //
		.filter(SELECTABLE_FILTER) //
		.toArray(InsuranceProductType[]::new);
    }

    private static final Predicate<InsuranceProductType> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final InsuranceProductType[] nonSelectableValues() {
	return valuesStream() //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(InsuranceProductType[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }
}
