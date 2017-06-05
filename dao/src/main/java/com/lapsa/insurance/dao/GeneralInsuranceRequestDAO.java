package com.lapsa.insurance.dao;

import java.util.List;

import com.lapsa.insurance.domain.InsuranceRequest;

public interface GeneralInsuranceRequestDAO<T extends InsuranceRequest> extends GeneralRequestDAO<T> {

    List<T> findByPaymentReference(String paymentReference) throws PeristenceOperationFailed;

    List<T> findOpenUnpaidByPaycardOnline() throws PeristenceOperationFailed;
}
