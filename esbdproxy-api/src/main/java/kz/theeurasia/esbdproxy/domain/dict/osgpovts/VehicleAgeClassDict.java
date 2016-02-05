package kz.theeurasia.esbdproxy.domain.dict.osgpovts;

public enum VehicleAgeClassDict {
    UNDER7(1), // До 7 лет включительно
    OVER7(2), // Свыше 7 лет
    UNSPECIFIED(0);

    private final long id;

    VehicleAgeClassDict(long id) {
	this.id = id;
    }

    public static VehicleAgeClassDict forId(long id) {
	for (VehicleAgeClassDict dict : values())
	    if (dict.getId() == id)
		return dict;
	return null;
    }

    // GENERATED

    public long getId() {
	return id;
    }
}
