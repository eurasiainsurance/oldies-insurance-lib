package kz.theeurasia.esbdproxy.domain.dict.osgpovts;

import kz.theeurasia.esbdproxy.domain.infos.osgpovts.DriverExpirienceClassInfo;
import kz.theeurasia.esbdproxy.domain.infos.osgpovts.InsuredAgeClassInfo;

public enum InsuredDriverExpirienceClassComplexDict {
    OVER25_MORE2(4, InsuredAgeClassInfo.OVER25, DriverExpirienceClassInfo.MORE2), //
    UNDER25_LESS2(1, InsuredAgeClassInfo.UNDER25, DriverExpirienceClassInfo.LESS2), //
    UNDER25_MORE2(2, InsuredAgeClassInfo.OVER25, DriverExpirienceClassInfo.MORE2), //
    OVER25_LESS2(3, InsuredAgeClassInfo.UNDER25, DriverExpirienceClassInfo.LESS2), //
    UNSPECIFIED(0, InsuredAgeClassInfo.UNSPECIFIED, DriverExpirienceClassInfo.UNSPECIFIED);

    private final long id;
    private final DriverExpirienceClassInfo expirienceClass;
    private final InsuredAgeClassInfo ageClass;

    InsuredDriverExpirienceClassComplexDict(long id, InsuredAgeClassInfo ageClass,
	    DriverExpirienceClassInfo expirienceClass) {
	this.id = id;
	this.expirienceClass = expirienceClass;
	this.ageClass = ageClass;
    }

    public long getId() {
	return id;
    }

    public DriverExpirienceClassInfo getExpirienceClass() {
	return expirienceClass;
    }

    public InsuredAgeClassInfo getAgeClass() {
	return ageClass;
    }

    public static InsuredDriverExpirienceClassComplexDict forId(long id) {
	for (InsuredDriverExpirienceClassComplexDict dict : values())
	    if (dict.getId() == id)
		return dict;
	return null;
    }
}
