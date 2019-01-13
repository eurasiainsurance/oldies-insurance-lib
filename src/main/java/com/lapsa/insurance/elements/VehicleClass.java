package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

import tech.lapsa.java.commons.localization.LocalizedElement;

public enum VehicleClass implements LocalizedElement {
    CAR(true, true), // Легковые
    MOTO(true, true), // Мототранспорт
    CARGO(true, true), // Грузовые
    TRAILER(true, true), // Прицепы (полуприцепы)
    BUS16(true, true), // Автобусы до 16 пассажирских мест включительно
    BUSOVR16(true, true), // Автобусы свыше 16 пассажирских мест
    TRAM(true, false), // Троллейбусы, трамваи
    SEA(true, false), // Морское
    AIRCRAFT(true, false), // Воздушный транспорт
    RAILWAY(true, false), // Железнодорожный транспорт
    SPECIAL(true, false), // Спец.техника
    ;

    //

    private final boolean selectable;
    private final boolean validForMotorTPL;

    //

    private VehicleClass(final boolean validForMotorTPL, final boolean selectable) {
	this.validForMotorTPL = validForMotorTPL;
	this.selectable = selectable;
    }

    //

    public static final Stream<VehicleClass> valuesStream() {
	return Stream.of(values());
    }

    //

    private static final Predicate<VehicleClass> SELECTABLE_FILTER = VehicleClass::isSelectable;

    public static final VehicleClass[] selectableValues() {
	return valuesStream() //
		.filter(SELECTABLE_FILTER) //
		.toArray(VehicleClass[]::new);
    }

    private static final Predicate<VehicleClass> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final VehicleClass[] nonSelectableValues() {
	return valuesStream() //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(VehicleClass[]::new);
    }

    private static final Predicate<VehicleClass> VALID_FOR_MOTOR_TPL_FILTER = VehicleClass::isValidForMotorTPL;

    public static final VehicleClass[] validForMotorTPLValues() {
	return valuesStream() //
		.filter(VALID_FOR_MOTOR_TPL_FILTER) //
		.toArray(VehicleClass[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }

    public boolean isValidForMotorTPL() {
	return validForMotorTPL;
    }
}
