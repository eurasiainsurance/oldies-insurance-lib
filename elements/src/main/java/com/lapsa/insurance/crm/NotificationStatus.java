package com.lapsa.insurance.crm;

import com.lapsa.insurance.ElementsBundleBase;

public enum NotificationStatus implements ElementsBundleBase {
    PENDING, // Завершено
    DONE, // В очереди
    NOT_REQUIRED, // не требуется
    //
    ;

    @Override
    public String canonicalName() {
	return String.format("%1$s.%2$s", this.getClass().getName(), name());
    }
}
