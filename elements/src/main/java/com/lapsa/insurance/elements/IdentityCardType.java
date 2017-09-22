package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

public enum IdentityCardType implements InsuranceLocalizedElement {
    ID_CARD, // удостоверение личности
    PASSPORT, // паспорт
    BIRTH_CERTIFICATE, // свидетельство о рождении
    RESIDENCE_PERMIT, // вид на жительство иностранца
    ;

    //

    private final boolean selectable;

    //

    private IdentityCardType() {
	this.selectable = true;
    }

    private IdentityCardType(boolean selectable) {
	this.selectable = selectable;
    }

    //

    public static final Stream<IdentityCardType> valuesStream() {
	return Stream.of(values());
    }

    //

    private static final Predicate<IdentityCardType> SELECTABLE_FILTER = IdentityCardType::isSelectable;

    public static final IdentityCardType[] selectableValues() {
	return valuesStream() //
		.filter(SELECTABLE_FILTER) //
		.toArray(IdentityCardType[]::new);
    }

    private static final Predicate<IdentityCardType> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final IdentityCardType[] nonSelectableValues() {
	return valuesStream() //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(IdentityCardType[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }
}
