package com.lapsa.insurance.persistence.dao;

import java.util.List;

import com.lapsa.insurance.crm.RequestStatus;
import com.lapsa.insurance.domain.PolicyExpressOrder;

public interface PolicyExpressOrderDAO extends DAO<PolicyExpressOrder, Integer> {

    List<PolicyExpressOrder> findByStatus(RequestStatus status);

    List<PolicyExpressOrder> findAllOpen();

    List<PolicyExpressOrder> findAll();

    List<PolicyExpressOrder> findByPaymentReference(String paymentReference);
}
