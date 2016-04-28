package kz.theeurasia.esbdproxy.domain.dict.general;

//TODO перенести в domain 
public enum MaritalStatusDict {
    MARRIED(1), // женат / замужем
    SINGLE(2); // холост / незамужем

    private final long id;

    MaritalStatusDict(long id) {
	this.id = id;
    }

    @Deprecated
    public static MaritalStatusDict forId(long id) {
	for (MaritalStatusDict dict : values())
	    if (dict.getId() == id)
		return dict;
	return null;
    }

    // GENERATED

    @Deprecated
    public long getId() {
	return id;
    }
}
