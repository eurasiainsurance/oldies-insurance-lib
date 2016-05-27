package com.lapsa.insurance.elements;

public enum InsuredAgeAndExpirienceClass implements ElementsBundleBase {
    OVER25_MORE2(InsuredAgeClass.OVER25, InsuredExpirienceClass.MORE2), // возраст старше 25 лет, стаж вождения более 2 лет
    UNDER25_LESS2(InsuredAgeClass.UNDER25, InsuredExpirienceClass.LESS2), // возраст моложе 25 лет, стаж вождения менее 2 лет
    UNDER25_MORE2(InsuredAgeClass.UNDER25, InsuredExpirienceClass.MORE2), // возраст моложе 25 лет, стаж вождения более 2 лет
    OVER25_LESS2(InsuredAgeClass.OVER25, InsuredExpirienceClass.LESS2), // возраст старше 25 лет, стаж вождения менее 2 лет
    //
    ;

    @Override
    public String canonicalName() {
	return String.format("%1$s.%2$s", this.getClass().getName(), name());
    }

    private final InsuredExpirienceClass expirienceClass;
    private final InsuredAgeClass ageClass;

    InsuredAgeAndExpirienceClass(InsuredAgeClass ageClass, InsuredExpirienceClass expirienceClass) {
	this.expirienceClass = expirienceClass;
	this.ageClass = ageClass;
    }

    public static InsuredAgeAndExpirienceClass forPair(InsuredExpirienceClass expirienceClass,
	    InsuredAgeClass ageClass) {
	for (InsuredAgeAndExpirienceClass dict : values())
	    if (dict.getAgeClass() == ageClass && dict.getExpirienceClass() == expirienceClass)
		return dict;
	return null;
    }

    // GENERATED

    public InsuredExpirienceClass getExpirienceClass() {
	return expirienceClass;
    }

    public InsuredAgeClass getAgeClass() {
	return ageClass;
    }
}
