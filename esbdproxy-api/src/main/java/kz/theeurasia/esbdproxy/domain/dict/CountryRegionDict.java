package kz.theeurasia.esbdproxy.domain.dict;

public enum CountryRegionDict {
    GAST(16, "01", true), // Астана - код 01
    GALM(15, "02", true), // Алматы - код 02
    OAKM(7, "03", true), // Акмолинская область - код 03
    OAKT(10, "04", true), // Актюбинская область - код 04
    OALM(1, "05", true), // Алматинская область - код 05
    OATY(13, "06", true), // Атырауская область - код 06
    OZK(11, "07", true), // Западно-Казахстанская область - код 07
    OZHM(9, "08", true), // Жамбылская область - код 08
    OKGD(5, "09", true), // Карагандинская область - код 09
    OKST(4, "10", true), // Костанайская область - код 10
    OKZL(12, "11", true), // Кызылординская область - код 11
    OMNG(14, "12", true), // Мангистауская область - код 12
    OUK(2, "13", true), // Южно-Казахстанская область - код 13
    OPVL(8, "14", true), // Павлодарская область - код 14
    OSK(6, "15", true), // Северо-Казахстанская область - код 15
    OVK(3, "16", true), // Восточно-Казахстанская область - код 16
    UNSPECIFIED1(18, "", false), // Временная регистрация?!
    UNSPECIFIED2(17, "", false), // Временная въезд?!
    UNSPECIFIED(0, "", false);

    private final long id;
    private final String code;
    private final boolean region;

    CountryRegionDict(long id, String code, boolean region) {
	this.id = id;
	this.code = code;
	this.region = region;
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

    public boolean isRegion() {
	return region;
    }

}
