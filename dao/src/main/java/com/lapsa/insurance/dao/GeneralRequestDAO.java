package com.lapsa.insurance.dao;

import java.util.List;

import com.lapsa.insurance.crm.RequestStatus;
import com.lapsa.insurance.dao.filter.RequestFilter;
import com.lapsa.insurance.domain.Request;

public interface GeneralRequestDAO<T extends Request> extends GeneralDAO<T, Integer> {

    List<T> findByStatus(RequestStatus status) throws PeristenceOperationFailed;

    List<T> findAllOpen() throws PeristenceOperationFailed;

    List<T> findAll() throws PeristenceOperationFailed;

    List<T> findByFilter(RequestFilter filter) throws PeristenceOperationFailed;
}
