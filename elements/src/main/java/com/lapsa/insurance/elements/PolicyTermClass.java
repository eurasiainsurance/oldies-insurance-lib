package com.lapsa.insurance.elements;

import com.lapsa.insurance.ElementsBundleBase;

public enum PolicyTermClass implements ElementsBundleBase {
    YEAR, // 1 год
    DAY5, // 5 дней
    MONTH1_2, // от 1 до 2 месяцев включительно
    MONTH10_11, // от 10 до 11 месяцев включительно
    DAY16_MONTH, // от 16 дней до 1 месяца включительно
    MONTH2_3, // от 2 до 3 месяцев включительно
    MONTH3_4, // от 3 до 4 месяцев включительно
    MONTH4_5, // от 4 до 5 месяцев включительно
    MONTH5_6, // от 5 до 6 месяцев включительно
    DAY6_15, // от 6 до 15 дней включительно
    MONTH6_7, // от 6 до 7 месяцев включительно
    MONTH7_8, // от 7 до 8 месяцев включительно
    MONTH8_9, // от 8 до 9 месяцев включительно
    MONTH9_10, // от 9 до 10 месяцев включительно
    OVER11MONTH, // свыше 11 месяцев
    //
    ;

    @Override
    public String canonicalName() {
	return String.format("%1$s.%2$s", this.getClass().getName(), name());
    }
}
