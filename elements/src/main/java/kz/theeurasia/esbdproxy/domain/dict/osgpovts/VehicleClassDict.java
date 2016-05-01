package kz.theeurasia.esbdproxy.domain.dict.osgpovts;

public enum VehicleClassDict {
    BUS16(true), // Автобусы до 16 пассажирских мест включительно
    BUSOVR16(true), // Автобусы свыше 16 пассажирских мест
    CARGO(true), // Грузовые
    CAR(true), // Легковые
    MOTO(true), // Мототранспорт
    TRAILER(true), // Прицепы (полуприцепы)
    TRAM(true), // Троллейбусы, трамваи
    SEA(false), // Морское
    AIRCRAFT(false), // Воздушный транспорт
    RAILWAY(false), // Железнодорожный транспорт
    SPECIAL(false); // Спец.техника

    private final boolean applicableForOSGPOVTS;

    VehicleClassDict(boolean applicableForOSGPOVTS) {
	this.applicableForOSGPOVTS = applicableForOSGPOVTS;
    }

    public boolean isApplicableForOSGPOVTS() {
	return applicableForOSGPOVTS;
    }
}
