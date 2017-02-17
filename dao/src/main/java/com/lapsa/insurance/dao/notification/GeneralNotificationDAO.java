package com.lapsa.insurance.dao.notification;

import java.util.List;

import com.lapsa.insurance.crm.NotificationChannel;
import com.lapsa.insurance.dao.GeneralDAO;
import com.lapsa.insurance.dao.PeristenceOperationFailed;
import com.lapsa.insurance.domain.notification.Notification;

public interface GeneralNotificationDAO<T extends Notification> extends GeneralDAO<T, Integer> {
    List<T> findAllPending() throws PeristenceOperationFailed;

    List<T> findAllPendingByChannel(NotificationChannel channel) throws PeristenceOperationFailed;
}
