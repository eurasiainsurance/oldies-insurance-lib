package com.lapsa.insurance.elements;

import com.lapsa.insurance.ElementsBundleBase;

public enum PolicyContractTimeClass implements ElementsBundleBase {
    TO_15D_INCL, // до 15 дней включительно
    FROM_16D_TO_1M_INCL, // от 16 дней до 1 месяца включительно
    FROM_1M_TO_2M_INCL, // от 1 до 2 месяцев включительно
    FROM_2M_TO_3M_INCL, // от 2 до 3 месяцев включительно
    FROM_3M_TO_4M_INCL, // от 3 до 4 месяцев включительно
    FROM_4M_TO_5M_INCL, // от 4 до 5 месяцев включительно
    FROM_5M_TO_6M_INCL, // от 5 до 6 месяцев включительно
    FROM_6M_TO_7M_INCL, // от 6 до 7 месяцев включительно
    FROM_7M_TO_8M_INCL, // от 7 до 8 месяцев включительно
    FROM_8M_TO_9M_INCL, // от 8 до 9 месяцев включительно
    FROM_9M_TO_10M_INCL, // от 9 до 10 месяцев включительно
    FROM_10M_TO_11M_INCL, // от 10 до 11 месяцев включительно
    FROM_11M, // свыше 11 месяцев
    //
    ;

    @Override
    public String canonicalName() {
	return String.format("%1$s.%2$s", this.getClass().getName(), name());
    }

}
