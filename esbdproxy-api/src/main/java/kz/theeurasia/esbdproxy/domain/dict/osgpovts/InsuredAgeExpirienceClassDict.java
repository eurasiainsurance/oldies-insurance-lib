package kz.theeurasia.esbdproxy.domain.dict.osgpovts;

import kz.theeurasia.esbdproxy.domain.enums.osgpovts.InsuredAgeClassEnum;
import kz.theeurasia.esbdproxy.domain.enums.osgpovts.InsuredExpirienceClassEnum;

public enum InsuredAgeExpirienceClassDict {
    OVER25_MORE2(4, InsuredAgeClassEnum.OVER25, InsuredExpirienceClassEnum.MORE2), //
    UNDER25_LESS2(1, InsuredAgeClassEnum.UNDER25, InsuredExpirienceClassEnum.LESS2), //
    UNDER25_MORE2(2, InsuredAgeClassEnum.OVER25, InsuredExpirienceClassEnum.MORE2), //
    OVER25_LESS2(3, InsuredAgeClassEnum.UNDER25, InsuredExpirienceClassEnum.LESS2), //
    UNSPECIFIED(0, InsuredAgeClassEnum.UNSPECIFIED, InsuredExpirienceClassEnum.UNSPECIFIED);

    private final long id;
    private final InsuredExpirienceClassEnum expirienceClass;
    private final InsuredAgeClassEnum ageClass;

    InsuredAgeExpirienceClassDict(long id, InsuredAgeClassEnum ageClass,
	    InsuredExpirienceClassEnum expirienceClass) {
	this.id = id;
	this.expirienceClass = expirienceClass;
	this.ageClass = ageClass;
    }

    public static InsuredAgeExpirienceClassDict forId(long id) {
	for (InsuredAgeExpirienceClassDict dict : values())
	    if (dict.getId() == id)
		return dict;
	return null;
    }

    public static InsuredAgeExpirienceClassDict forPair(InsuredExpirienceClassEnum expirienceClass,
	    InsuredAgeClassEnum ageClass) {
	for (InsuredAgeExpirienceClassDict dict : values())
	    if (dict.getAgeClass() == ageClass && dict.getExpirienceClass() == expirienceClass)
		return dict;
	return UNSPECIFIED;
    }

    // GENERATED

    public long getId() {
	return id;
    }

    public InsuredExpirienceClassEnum getExpirienceClass() {
	return expirienceClass;
    }

    public InsuredAgeClassEnum getAgeClass() {
	return ageClass;
    }
}
