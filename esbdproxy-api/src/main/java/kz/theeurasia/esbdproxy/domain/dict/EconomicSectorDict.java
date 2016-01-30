package kz.theeurasia.esbdproxy.domain.dict;

public enum EconomicSectorDict {
    GOVERNMENT(2, "1"), // Правительство Республики Казахстан
    ADMINISTRATION(3, "2"), // Региональные и местные органы управления
    CENTRAL_BANK(4, "3"), // Национальный банк РК и Центральные Банки других
			  // стран
    DEPOSITORY(5, "4"), // Другие депозитные организации
    FINANCIAL(6, "5"), // Другие финансовые организации

    GOVERNMENT_NONFINALCIAL(7, "6"), // Государственные нефинансовые организации
    NONGOVERNMENT_NONFINALCIAL(8, "7"), // Негосударственные нефинансовые
					// организации
    NONPROFIT_FOR_HOUSEHOLDS(9, "8"), // Некоммерческие организации,
				      // обслуживающие домашние хозяйства
    HOUSEHOLDS(10, "9"), // Домашние хозяйства
    INTERNATIONAL_COMPANIES(11, "А"), // Международные организации
    UNSPECIFIED(0, "");

    private final long id;
    private final String code;

    EconomicSectorDict(long id, String code) {
	this.id = id;
	this.code = code;
    }

    public static EconomicSectorDict forId(long id) {
	for (EconomicSectorDict ent : values())
	    if (ent.getId() == id)
		return ent;
	return null;
    }

    public static EconomicSectorDict forCode(String code) {
	for (EconomicSectorDict ent : values())
	    if (ent.getCode().equals(code))
		return ent;
	return null;
    }

    // GENERATED

    public long getId() {
	return id;
    }

    public String getCode() {
	return code;
    }

}
