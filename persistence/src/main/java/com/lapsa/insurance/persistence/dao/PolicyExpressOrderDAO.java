package com.lapsa.insurance.persistence.dao;

import com.lapsa.insurance.persistence.entities.PolicyExpressOrder;

public interface PolicyExpressOrderDAO {

    PolicyExpressOrder findById(int id);

    PolicyExpressOrder save(PolicyExpressOrder policyExpressOrder);
}
