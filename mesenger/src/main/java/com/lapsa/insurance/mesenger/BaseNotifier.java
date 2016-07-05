package com.lapsa.insurance.mesenger;

import java.util.Collection;

import com.lapsa.insurance.domain.notification.Notification;

public interface BaseNotifier<T extends Notification> {

    /**
     * Send the notification entity and throws exception if somethig goes wrong
     * 
     * @param enitity
     *            notifciation entity
     * @throws NotificationFailed
     *             exception throws
     */
    void sendNotification(T enitity) throws NotificationFailed;

    /**
     * Methods sent a collection of Notification entities
     * 
     * @param enitities
     *            a collection of Notification entities to sent
     * @return number of notifications that was realy sent without exceptions
     */
    int sendMultipleNotification(Collection<T> enitities);
}
