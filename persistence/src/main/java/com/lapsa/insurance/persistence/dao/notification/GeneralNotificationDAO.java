package com.lapsa.insurance.persistence.dao.notification;

import java.util.List;

import com.lapsa.insurance.domain.notification.Notification;
import com.lapsa.insurance.persistence.dao.DAO;

public interface BaseNotificationDAO<T extends Notification> extends DAO<T, Integer> {
    List<T> findAllPending();
}
