package kz.theeurasia.esbdproxy.domain.dict;

public enum CompanyActivityKindDict {
    UNSPECIFIED(0);

    private final long id;

    CompanyActivityKindDict(long id) {
	this.id = id;
    }

    public static CompanyActivityKindDict forId(long id) {
	for (CompanyActivityKindDict ent : values())
	    if (ent.getId() == id)
		return ent;
	return null;
    }

    // GENERATED

    public long getId() {
	return id;
    }

}
