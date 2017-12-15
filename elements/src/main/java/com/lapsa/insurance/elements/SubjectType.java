package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

import tech.lapsa.java.commons.localization.LocalizedElement;

public enum SubjectType implements LocalizedElement {
    COMPANY, // юрлицо
    PERSON, // физлицо
    ;

    //

    private final boolean selectable;

    //

    private SubjectType() {
	selectable = true;
    }

    private SubjectType(final boolean selectable) {
	this.selectable = selectable;
    }

    //

    public static final Stream<SubjectType> valuesStream() {
	return Stream.of(values());
    }

    //

    private static final Predicate<SubjectType> SELECTABLE_FILTER = SubjectType::isSelectable;

    public static final SubjectType[] selectableValues() {
	return valuesStream() //
		.filter(SELECTABLE_FILTER) //
		.toArray(SubjectType[]::new);
    }

    private static final Predicate<SubjectType> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final SubjectType[] nonSelectableValues() {
	return valuesStream() //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(SubjectType[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }
}
