package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

public enum SubjectType implements InsuranceLocalizedElement {
    COMPANY, // юрлицо
    PERSON, // физлицо
    ;

    //

    private final boolean selectable;

    //

    private SubjectType() {
	this.selectable = true;
    }

    private SubjectType(boolean selectable) {
	this.selectable = selectable;
    }

    //

    private static final Predicate<SubjectType> SELECTABLE_FILTER = SubjectType::isSelectable;

    public static final SubjectType[] selectableValues() {
	return Stream.of(values()) //
		.filter(SELECTABLE_FILTER) //
		.toArray(SubjectType[]::new);
    }

    private static final Predicate<SubjectType> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final SubjectType[] nonSelectableValues() {
	return Stream.of(values()) //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(SubjectType[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }
}
