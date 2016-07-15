package com.lapsa.insurance.esbd.services.osgpovts;

import com.lapsa.insurance.esbd.domain.entities.osgpovts.PolicyEntity;
import com.lapsa.insurance.esbd.services.GeneralServiceDAO;
import com.lapsa.insurance.esbd.services.InvalidInputParameter;
import com.lapsa.insurance.esbd.services.NotFound;

public interface PolicyServiceDAO extends GeneralServiceDAO<PolicyEntity, Long> {
    PolicyEntity getByNumber(String number) throws NotFound, InvalidInputParameter;
}
