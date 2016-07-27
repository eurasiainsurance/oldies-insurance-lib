package com.lapsa.insurance.persistence.dao.notification;

import java.util.List;

import com.lapsa.insurance.domain.notification.Notification;
import com.lapsa.insurance.persistence.dao.GeneralDAO;
import com.lapsa.insurance.persistence.dao.PeristenceOperationFailed;

public interface GeneralNotificationDAO<T extends Notification> extends GeneralDAO<T, Integer> {
    List<T> findAllPending() throws PeristenceOperationFailed;
}
