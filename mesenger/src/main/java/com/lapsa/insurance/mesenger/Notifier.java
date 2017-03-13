package com.lapsa.insurance.mesenger;

import com.lapsa.insurance.domain.Request;

public interface Notifier {
    void assignRequestNotification(NotificationChannel channel, NotificationRecipientType recipientType, NotificationRequestStage stage,
	    Request request) throws NotificationFailed;
}
