package kz.theeurasia.esbdproxy.dict.osgpovts;

public enum VehicleAgeClassDict {
    UNDER7(1), // До 7 лет включительно
    OVER7(2); // Свыше 7 лет

    private final long id;

    VehicleAgeClassDict(long id) {
	this.id = id;
    }

    public long getId() {
	return id;
    }

    public static VehicleAgeClassDict forId(long id) {
	for (VehicleAgeClassDict dict : values())
	    if (dict.getId() == id)
		return dict;
	return null;
    }
}
