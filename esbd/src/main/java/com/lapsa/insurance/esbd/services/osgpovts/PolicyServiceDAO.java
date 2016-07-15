package com.lapsa.insurance.esbd.services.osgpovts;

import com.lapsa.insurance.esbd.services.GeneralServiceDAO;
import com.lapsa.insurance.esbd.services.InvalidInputParameter;
import com.lapsa.insurance.esbd.services.NotFound;

import kz.theeurasia.esbdproxy.domain.entities.osgpovts.PolicyEntity;

public interface PolicyServiceDAO extends GeneralServiceDAO<PolicyEntity, Long> {
    PolicyEntity getByNumber(String number) throws NotFound, InvalidInputParameter;
}
