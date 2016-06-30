package com.lapsa.insurance.elements;

import com.lapsa.insurance.ElementsBundleBase;

public enum WhoIsInsurant implements ElementsBundleBase {
    DRIVER, // Страхователем является один из застрахованных водителей
    OTHER, // Страхователем является другое лицо
    //
    ;

    @Override
    public String canonicalName() {
	return String.format("%1$s.%2$s", this.getClass().getName(), name());
    }
}
