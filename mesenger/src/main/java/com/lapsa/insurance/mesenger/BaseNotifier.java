package com.lapsa.insurance.mesenger;

import java.util.List;

import com.lapsa.insurance.domain.notification.Notification;

public interface BaseNotifier<T extends Notification> {
    void notify(T enitity) throws NotificationFailed;

    void notifyAll(List<T> enitities) throws NotificationFailed;
}
