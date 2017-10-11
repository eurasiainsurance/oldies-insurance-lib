package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.java.commons.localization.LocalizedElement;

public enum InsuredAgeAndExpirienceClass implements LocalizedElement {
    // возраст старше 25 лет, стаж вождения более 2 лет
    OVER25_MORE2(InsuredAgeClass.OVER25, InsuredExpirienceClass.MORE2),
    // возраст моложе 25 лет, стаж вождения менее 2 лет
    UNDER25_LESS2(InsuredAgeClass.UNDER25, InsuredExpirienceClass.LESS2),
    // возраст моложе 25 лет, стаж вождения более 2 лет
    UNDER25_MORE2(InsuredAgeClass.UNDER25, InsuredExpirienceClass.MORE2),
    // возраст старше 25 лет, стаж вождения менее 2 лет
    OVER25_LESS2(InsuredAgeClass.OVER25, InsuredExpirienceClass.LESS2),
    ;

    //

    private final boolean selectable;
    private final InsuredExpirienceClass expirienceClass;
    private final InsuredAgeClass ageClass;

    //

    private InsuredAgeAndExpirienceClass(InsuredAgeClass ageClass, InsuredExpirienceClass expirienceClass) {
	this.selectable = true;
	this.expirienceClass = MyObjects.requireNonNull(expirienceClass);
	this.ageClass = MyObjects.requireNonNull(ageClass);
    }

    private InsuredAgeAndExpirienceClass(InsuredAgeClass ageClass, InsuredExpirienceClass expirienceClass,
	    boolean selectable) {
	this.selectable = selectable;
	this.expirienceClass = MyObjects.requireNonNull(expirienceClass);
	this.ageClass = MyObjects.requireNonNull(ageClass);
    }

    //

    public static final Stream<InsuredAgeAndExpirienceClass> valuesStream() {
	return Stream.of(values());
    }

    //

    private static final Predicate<InsuredAgeAndExpirienceClass> SELECTABLE_FILTER = InsuredAgeAndExpirienceClass::isSelectable;

    public static final InsuredAgeAndExpirienceClass[] selectableValues() {
	return valuesStream() //
		.filter(SELECTABLE_FILTER) //
		.toArray(InsuredAgeAndExpirienceClass[]::new);
    }

    private static final Predicate<InsuredAgeAndExpirienceClass> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final InsuredAgeAndExpirienceClass[] nonSelectableValues() {
	return valuesStream() //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(InsuredAgeAndExpirienceClass[]::new);
    }

    public static InsuredAgeAndExpirienceClass forPair(InsuredExpirienceClass expirienceClass,
	    InsuredAgeClass ageClass) {
	return Stream.of(values()) //
		.filter(x -> ageClass == x.ageClass) //
		.filter(x -> expirienceClass == x.expirienceClass) //
		.findAny() //
		.orElse(null);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }

    public InsuredExpirienceClass getExpirienceClass() {
	return expirienceClass;
    }

    public InsuredAgeClass getAgeClass() {
	return ageClass;
    }
}
