package kz.theeurasia.esbdproxy.domain.dict.general;

//TODO перенести в domain 
public enum SexDict {
    MALE(1), FEMALE(2);

    private final long id;

    SexDict(long id) {
	this.id = id;
    }

    @Deprecated
    public static SexDict forId(long id) {
	for (SexDict dict : values())
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
