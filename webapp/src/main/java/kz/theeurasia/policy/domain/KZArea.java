package kz.theeurasia.policy.domain;

public enum KZArea {
    GAST("01"), // Астана - код 01
    GALM("02"), // Алматы - код 02
    OAKM("03"), // Акмолинская область - код 03
    OAKT("04"), // Актюбинская область - код 04
    OALM("05"), // Алматинская область - код 05
    OATY("06"), // Атырауская область - код 06
    OZK("07"), // Западно-Казахстанская область - код 07
    OZHM("08"), // Жамбылская область - код 08
    OKGD("09"), // Карагандинская область - код 09
    OKST("10"), // Костанайская область - код 10
    OKZL("11"), // Кызылординская область - код 11
    OMNG("12"), // Мангистауская область - код 12
    OUK("13"), // Южно-Казахстанская область - код 13
    OPVL("14"), // Павлодарская область - код 14
    OSK("15"), // Северо-Казахстанская область - код 15
    OVK("16"), // Восточно-Казахстанская область - код 16
    RUSAGEN("--"); 

    private final String code;

    KZArea(String code) {
	this.code = code;
    }

    public String getCode() {
	return code;
    }

    public static KZArea forCode(String code) {
	for (KZArea dict : values())
	    if (dict.getCode() == code)
		return dict;
	return null;
    }

}
