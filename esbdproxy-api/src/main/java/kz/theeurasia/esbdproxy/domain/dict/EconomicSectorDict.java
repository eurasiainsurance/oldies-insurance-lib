package kz.theeurasia.esbdproxy.domain.dict;

public enum EconomicSectorDict {
    UNSPECIFIED(0);

    private final long id;

    EconomicSectorDict(long id) {
	this.id = id;
    }

    public static EconomicSectorDict forId(long id) {
	for (EconomicSectorDict ent : values())
	    if (ent.getId() == id)
		return ent;
	return null;
    }

    // GENERATED

    public long getId() {
	return id;
    }

}
