package kz.theeurasia.esbdproxy.domain.dict.general;

public enum IdentityCardTypeDict {
    ID_CARD(1), // удостоверение личности
    PASSPORT(2), // паспорт
    BIRTH_CERTIFICATE(3), // свидетельство о рождении
    RESIDENCE_PERMIT(4), // вид на жительство иностранца
    UNSPECIFIED(0);

    private final long id;

    IdentityCardTypeDict(long id) {
	this.id = id;
    }

    public static IdentityCardTypeDict forId(long id) {
	for (IdentityCardTypeDict dict : values())
	    if (dict.getId() == id)
		return dict;
	return null;
    }

    // GENERATED

    public long getId() {
	return id;
    }
}
