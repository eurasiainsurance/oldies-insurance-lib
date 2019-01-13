package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

import tech.lapsa.java.commons.localization.LocalizedElement;

public enum PersonType implements LocalizedElement {
    INDIVIDUAL, // Физическое лицо
    INDIVIDUAL_ENTREPRENEUR, // Индивидуальный предприниматель/Крестьянское
			     // (фермерское) хозяйство
    ;

    //

    private final boolean selectable;

    //

    private PersonType() {
	selectable = true;
    }

    private PersonType(final boolean selectable) {
	this.selectable = selectable;
    }

    //

    public static final Stream<PersonType> valuesStream() {
	return Stream.of(values());
    }

    //

    private static final Predicate<PersonType> SELECTABLE_FILTER = PersonType::isSelectable;

    public static final PersonType[] selectableValues() {
	return valuesStream() //
		.filter(SELECTABLE_FILTER) //
		.toArray(PersonType[]::new);
    }

    private static final Predicate<PersonType> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final PersonType[] nonSelectableValues() {
	return valuesStream() //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(PersonType[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }
}
