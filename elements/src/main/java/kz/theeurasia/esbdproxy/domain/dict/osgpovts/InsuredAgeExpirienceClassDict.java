package kz.theeurasia.esbdproxy.domain.dict.osgpovts;

import com.lapsa.insurance.elements.BundleBase;

import kz.theeurasia.esbdproxy.domain.enums.osgpovts.InsuredAgeClassEnum;
import kz.theeurasia.esbdproxy.domain.enums.osgpovts.InsuredExpirienceClassEnum;

public enum InsuredAgeExpirienceClassDict implements BundleBase {
    OVER25_MORE2(InsuredAgeClassEnum.OVER25, InsuredExpirienceClassEnum.MORE2), // возраст старше 25 лет, стаж вождения более 2 лет
    UNDER25_LESS2(InsuredAgeClassEnum.UNDER25, InsuredExpirienceClassEnum.LESS2), // возраст моложе 25 лет, стаж вождения менее 2 лет
    UNDER25_MORE2(InsuredAgeClassEnum.UNDER25, InsuredExpirienceClassEnum.MORE2), // возраст моложе 25 лет, стаж вождения более 2 лет
    OVER25_LESS2(InsuredAgeClassEnum.OVER25, InsuredExpirienceClassEnum.LESS2); // возраст старше 25 лет, стаж вождения менее 2 лет

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
