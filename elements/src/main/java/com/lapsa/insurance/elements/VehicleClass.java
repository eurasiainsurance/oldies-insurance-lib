package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

public enum VehicleClass implements InsuranceLocalizedElement {
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

    private static final Predicate<VehicleClass> SELECTABLE_FILTER = VehicleClass::isValidForIndividualsPolicy;

    public static final VehicleClass[] selectableValues() {
	return Stream.of(values()) //
		.filter(SELECTABLE_FILTER) //
		.toArray(VehicleClass[]::new);
    }

    private static final Predicate<VehicleClass> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final VehicleClass[] nonSelectableValues() {
	return Stream.of(values()) //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(VehicleClass[]::new);
    }

    // GENERATED

    public boolean isValidForIndividualsPolicy() {
	return validForIndividualsPolicy;
    }
}
