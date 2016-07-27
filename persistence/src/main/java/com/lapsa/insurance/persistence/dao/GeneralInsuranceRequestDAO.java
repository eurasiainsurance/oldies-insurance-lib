package com.lapsa.insurance.persistence.dao;

import java.util.List;

import com.lapsa.insurance.crm.RequestStatus;
import com.lapsa.insurance.domain.InsuranceRequest;

public interface GenericInsuranceRequestDAO<T extends InsuranceRequest> extends DAO<T, Integer> {

    List<T> findByStatus(RequestStatus status);

    List<T> findAllOpen();

    List<T> findAll();

    List<T> findByPaymentReference(String paymentReference);

    List<T> findOpenUnpaidByPaycardOnline();
}
