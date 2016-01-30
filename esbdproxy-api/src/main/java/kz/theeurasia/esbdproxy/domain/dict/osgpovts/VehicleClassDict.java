package kz.theeurasia.esbdproxy.domain.dict.osgpovts;

public enum VehicleClassDict {
    BUS16(5), // Автобусы до 16 пассажирских мест включительно
    BUSOVR16(11), // Автобусы свыше 16 пассажирских мест
    CARGO(6), // Грузовые
    CAR(4), // Легковые
    MOTO(8), // Мототранспорт
    TRAILER(10), // Прицепы (полуприцепы)
    TRAM(7), // Троллейбусы, трамваи
    SEA(13), // Морское
    AIRCRAFT(12), // Воздушный транспорт
    RAILWAY(14), // Железнодорожный транспорт
    SPECIAL(15), // Спец.техника
    UNSPECIFIED(0);

    private final long id;

    VehicleClassDict(long id) {
	this.id = id;
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
}
