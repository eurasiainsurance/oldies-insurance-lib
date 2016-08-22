package com.lapsa.insurance.persistence.dao;

import java.util.List;

import com.lapsa.insurance.crm.RequestStatus;
import com.lapsa.insurance.domain.InsuranceRequest;
import com.lapsa.insurance.persistence.dao.filter.InsuranceRequestFitler;

public interface GeneralInsuranceRequestDAO<T extends InsuranceRequest> extends GeneralDAO<T, Integer> {

    List<T> findByStatus(RequestStatus status) throws PeristenceOperationFailed;

    List<T> findAllOpen() throws PeristenceOperationFailed;

    List<T> findAll() throws PeristenceOperationFailed;
    
    List<T> findByFilter(InsuranceRequestFitler filter) throws PeristenceOperationFailed;

    List<T> findByPaymentReference(String paymentReference) throws PeristenceOperationFailed;

    List<T> findOpenUnpaidByPaycardOnline() throws PeristenceOperationFailed;
}
