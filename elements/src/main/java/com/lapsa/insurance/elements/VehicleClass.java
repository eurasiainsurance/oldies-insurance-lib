package com.lapsa.insurance.elements;

public enum VehicleClass implements LocalizedElement {
    CAR(true), // Легковые
    MOTO(true), // Мототранспорт
    CARGO(true), // Грузовые
    TRAILER(true), // Прицепы (полуприцепы)
    BUS16(true), // Автобусы до 16 пассажирских мест включительно
    BUSOVR16(true), // Автобусы свыше 16 пассажирских мест
    TRAM(false), // Троллейбусы, трамваи
    SEA(false), // Морское
    AIRCRAFT(false), // Воздушный транспорт
    RAILWAY(false), // Железнодорожный транспорт
    SPECIAL(false), // Спец.техника
    //
    ;

    private final boolean validForIndividualsPolicy;

    private VehicleClass(boolean validForIndividualsPolicy) {
	this.validForIndividualsPolicy = validForIndividualsPolicy;
    }

    public boolean isValidForIndividualsPolicy() {
	return validForIndividualsPolicy;
    }
}
