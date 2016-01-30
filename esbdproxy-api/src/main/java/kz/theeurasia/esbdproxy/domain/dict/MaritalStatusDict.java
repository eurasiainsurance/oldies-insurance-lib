package kz.theeurasia.esbdproxy.domain.dict;

public enum MaritalStatusDict {
    MARRIED(1), // женат / замужем
    SINGLE(2), // холост / незамужем
    UNSPECIFIED(0);

    private final long id;

    MaritalStatusDict(long id) {
	this.id = id;
    }

    public static MaritalStatusDict forId(long id) {
	for (MaritalStatusDict dict : values())
	    if (dict.getId() == id)
		return dict;
	return null;
    }

    // GENERATED

    public long getId() {
	return id;
    }
}
