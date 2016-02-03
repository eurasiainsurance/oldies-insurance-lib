package kz.theeurasia.esbdproxy.domain.dict.osgpovts;

public enum VehicleClassDict {
    BUS16(5, true), // Автобусы до 16 пассажирских мест включительно
    BUSOVR16(11, true), // Автобусы свыше 16 пассажирских мест
    CARGO(6, true), // Грузовые
    CAR(4, true), // Легковые
    MOTO(8, true), // Мототранспорт
    TRAILER(10, true), // Прицепы (полуприцепы)
    TRAM(7, true), // Троллейбусы, трамваи
    SEA(13, false), // Морское
    AIRCRAFT(12, false), // Воздушный транспорт
    RAILWAY(14, false), // Железнодорожный транспорт
    SPECIAL(15, false), // Спец.техника
    UNSPECIFIED(0, false);

    private final long id;
    private final boolean applicableForOSGPOVTS;

    VehicleClassDict(long id, boolean applicableForOSGPOVTS) {
	this.id = id;
	this.applicableForOSGPOVTS = applicableForOSGPOVTS;
    }

    public static VehicleClassDict forId(long id) {
	for (VehicleClassDict dict : values())
	    if (dict.getId() == id)
		return dict;
	return null;
    }

    // GENERATED

    public long getId() {
	return id;
    }

    public boolean isApplicableForOSGPOVTS() {
	return applicableForOSGPOVTS;
    }
}
