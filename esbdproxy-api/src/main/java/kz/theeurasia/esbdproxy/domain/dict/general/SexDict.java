package kz.theeurasia.esbdproxy.domain.dict.general;

public enum SexDict {
    MALE(1), FEMALE(2), UNSPECIFIED(0);

    private final long id;

    SexDict(long id) {
	this.id = id;
    }

    public static SexDict forId(long id) {
	for (SexDict dict : values())
	    if (dict.getId() == id)
		return dict;
	return null;
    }

    // GENERATED

    public long getId() {
	return id;
    }
}
