package com.lapsa.insurance.elements;

import com.lapsa.insurance.ElementsBundleBase;

public enum VehicleClass implements ElementsBundleBase {
    CAR(true), // Легковые
    MOTO(true), // Мототранспорт
    CARGO(true), // Грузовые
    TRAILER(true), // Прицепы (полуприцепы)
    BUS16(true), // Автобусы до 16 пассажирских мест включительно
    BUSOVR16(true), // Автобусы свыше 16 пассажирских мест
    TRAM(true), // Троллейбусы, трамваи
    SEA(false), // Морское
    AIRCRAFT(false), // Воздушный транспорт
    RAILWAY(false), // Железнодорожный транспорт
    SPECIAL(false), // Спец.техника
    //
    ;

    @Override
    public String canonicalName() {
	return String.format("%1$s.%2$s", this.getClass().getName(), name());
    }

    private final boolean applicableForOSGPOVTS;

    VehicleClass(boolean applicableForOSGPOVTS) {
	this.applicableForOSGPOVTS = applicableForOSGPOVTS;
    }

    public boolean isApplicableForOSGPOVTS() {
	return applicableForOSGPOVTS;
    }
}
