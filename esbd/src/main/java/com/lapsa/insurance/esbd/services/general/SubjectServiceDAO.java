package com.lapsa.insurance.esbd.services.general;

import com.lapsa.insurance.esbd.services.InvalidInputParameter;
import com.lapsa.insurance.esbd.services.NotFound;

import kz.theeurasia.esbdproxy.domain.entities.general.SubjectEntity;

public interface SubjectServiceDAO {
    SubjectEntity getById(Long id) throws NotFound, InvalidInputParameter;
    SubjectEntity getByIdNumber(String idNumber) throws NotFound, InvalidInputParameter;
}
