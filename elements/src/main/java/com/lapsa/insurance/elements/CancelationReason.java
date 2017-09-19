package com.lapsa.insurance.elements;

import com.lapsa.insurance.ElementsBundleBase;

public enum CancelationReason implements ElementsBundleBase {
    CANCELATION_AND_RENEW, // Досрочное прекращение договора и заключение
			   // нового
    CANCELATION, // Досрочное расторжение
    MADE_INSURANCE_PAYMENT, // Произведена страховая выплата
    PREMIUM_COST_ERROR, // Корректировка неверно рассчитанной премии
    POLICY_LOST, // Утеря
    ISSUED_DUPLICATE_POLICY, // Выпущен дубликат
    OTHER, // Другая причина
    HUMAN_FAILURE, // Ошибка оператора
    //
    ;
}
