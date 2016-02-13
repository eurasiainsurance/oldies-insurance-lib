package kz.theeurasia.esbdproxy.domain.dict.general;

public enum CountryRegionDict {
    GAST("01", true, 16), // Астана - код 01
    GALM("02", true, 15), // Алматы - код 02
    OAKM("03", true, 7), // Акмолинская область - код 03
    OAKT("04", true, 10), // Актюбинская область - код 04
    OALM("05", true, 1), // Алматинская область - код 05
    OATY("06", true, 13), // Атырауская область - код 06
    OZK("07", true, 11), // Западно-Казахстанская область - код 07
    OZHM("08", true, 9), // Жамбылская область - код 08
    OKGD("09", true, 5), // Карагандинская область - код 09
    OKST("10", true, 4), // Костанайская область - код 10
    OKZL("11", true, 12), // Кызылординская область - код 11
    OMNG("12", true, 14), // Мангистауская область - код 12
    OUK("13", true, 2), // Южно-Казахстанская область - код 13
    OPVL("14", true, 8), // Павлодарская область - код 14
    OSK("15", true, 6), // Северо-Казахстанская область - код 15
    OVK("16", true, 3), // Восточно-Казахстанская область - код 16
    TEMPORARY_REGISTRATION("Временная регистрация", false, 18), // Временная
								// регистрация?!
    TEMPORARY_ENTRY("Временная въезд", false, 17), // Временная въезд?!
    UNSPECIFIED("", true, 0);

    private final long id;
    private final String code;
    private final boolean selectable;

    CountryRegionDict(String code, boolean selectable, long id) {
	this.id = id;
	this.code = code;
	this.selectable = selectable;
    }

    public static CountryRegionDict forId(long id) {
	for (CountryRegionDict dict : values())
	    if (dict.getId() == id)
		return dict;
	return null;
    }

    public static CountryRegionDict forCode(String code) {
	for (CountryRegionDict dict : values())
	    if (dict.getCode() == code)
		return dict;
	return null;
    }

    // GENERATED

    public long getId() {
	return id;
    }

    public String getCode() {
	return code;
    }

    public boolean isSelectable() {
	return selectable;
    }

}
