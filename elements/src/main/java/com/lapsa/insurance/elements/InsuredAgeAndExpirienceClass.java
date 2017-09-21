package com.lapsa.insurance.elements;

import java.util.stream.Stream;

public enum InsuredAgeAndExpirienceClass implements InsuranceLocalizedElement {
    OVER25_MORE2(InsuredAgeClass.OVER25, InsuredExpirienceClass.MORE2), // возраст старше 25 лет, стаж вождения более 2 лет
    UNDER25_LESS2(InsuredAgeClass.UNDER25, InsuredExpirienceClass.LESS2), // возраст моложе 25 лет, стаж вождения менее 2 лет
    UNDER25_MORE2(InsuredAgeClass.UNDER25, InsuredExpirienceClass.MORE2), // возраст моложе 25 лет, стаж вождения более 2 лет
    OVER25_LESS2(InsuredAgeClass.OVER25, InsuredExpirienceClass.LESS2), // возраст старше 25 лет, стаж вождения менее 2 лет
    //
    ;

    private final InsuredExpirienceClass expirienceClass;
    private final InsuredAgeClass ageClass;

    private InsuredAgeAndExpirienceClass(InsuredAgeClass ageClass, InsuredExpirienceClass expirienceClass) {
	this.expirienceClass = expirienceClass;
	this.ageClass = ageClass;
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

    public InsuredExpirienceClass getExpirienceClass() {
	return expirienceClass;
    }

    public InsuredAgeClass getAgeClass() {
	return ageClass;
    }
}
