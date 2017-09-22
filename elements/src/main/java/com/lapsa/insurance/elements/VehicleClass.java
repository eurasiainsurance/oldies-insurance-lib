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
    ;

    //

    private final boolean selectable;

    //

    private VehicleClass(boolean selectable) {
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

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }
}
