package com.lapsa.insurance.persistence.dao;

import java.util.List;

import com.lapsa.insurance.crm.RequestStatus;
import com.lapsa.insurance.domain.PolicyExpressOrder;

public interface PolicyExpressOrderDAO {

    PolicyExpressOrder findById(int id);

    PolicyExpressOrder save(PolicyExpressOrder policyExpressOrder);

    void save(List<PolicyExpressOrder> policyExpressOrder);

    void save(PolicyExpressOrder... policyExpressOrder);

    List<PolicyExpressOrder> findByStatus(RequestStatus status);

    List<PolicyExpressOrder> findAllOpen();

    List<PolicyExpressOrder> findAll();

}
