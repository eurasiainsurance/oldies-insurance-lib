package com.lapsa.insurance.elements;

import com.lapsa.insurance.ElementsBundleBase;

public enum IdentityCardType implements ElementsBundleBase {
    ID_CARD, // удостоверение личности
    PASSPORT, // паспорт
    BIRTH_CERTIFICATE, // свидетельство о рождении
    RESIDENCE_PERMIT, // вид на жительство иностранца
    //
    ;

    @Override
    public String canonicalName() {
	return String.format("%1$s.%2$s", this.getClass().getName(), name());
    }
}
