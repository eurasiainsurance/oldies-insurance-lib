package com.lapsa.insurance.mesenger;

import java.util.List;

import com.lapsa.insurance.domain.notification.Notification;

public interface BaseNotifier<T extends Notification> {
    void sendNotification(T enitity) throws NotificationFailed;

    void sendNotification(List<T> enitities) throws NotificationFailed;
}
