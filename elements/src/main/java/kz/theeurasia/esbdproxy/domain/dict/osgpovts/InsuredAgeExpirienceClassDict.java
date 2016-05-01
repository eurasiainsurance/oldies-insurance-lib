package kz.theeurasia.esbdproxy.domain.dict.osgpovts;

import kz.theeurasia.esbdproxy.domain.enums.osgpovts.InsuredAgeClassEnum;
import kz.theeurasia.esbdproxy.domain.enums.osgpovts.InsuredExpirienceClassEnum;

public enum InsuredAgeExpirienceClassDict {
    OVER25_MORE2(InsuredAgeClassEnum.OVER25, InsuredExpirienceClassEnum.MORE2), //
    UNDER25_LESS2(InsuredAgeClassEnum.UNDER25, InsuredExpirienceClassEnum.LESS2), //
    UNDER25_MORE2(InsuredAgeClassEnum.OVER25, InsuredExpirienceClassEnum.MORE2), //
    OVER25_LESS2(InsuredAgeClassEnum.UNDER25, InsuredExpirienceClassEnum.LESS2); //

    private final InsuredExpirienceClassEnum expirienceClass;
    private final InsuredAgeClassEnum ageClass;

    InsuredAgeExpirienceClassDict(InsuredAgeClassEnum ageClass, InsuredExpirienceClassEnum expirienceClass) {
	this.expirienceClass = expirienceClass;
	this.ageClass = ageClass;
    }

    public static InsuredAgeExpirienceClassDict forPair(InsuredExpirienceClassEnum expirienceClass,
	    InsuredAgeClassEnum ageClass) {
	for (InsuredAgeExpirienceClassDict dict : values())
	    if (dict.getAgeClass() == ageClass && dict.getExpirienceClass() == expirienceClass)
		return dict;
	return null;
    }

    // GENERATED

    public InsuredExpirienceClassEnum getExpirienceClass() {
	return expirienceClass;
    }

    public InsuredAgeClassEnum getAgeClass() {
	return ageClass;
    }
}
