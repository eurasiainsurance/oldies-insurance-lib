package com.lapsa.insurance.esbd.services.general;

import com.lapsa.insurance.esbd.services.GeneralServiceDAO;
import com.lapsa.insurance.esbd.services.InvalidInputParameter;
import com.lapsa.insurance.esbd.services.NotFound;

import kz.theeurasia.esbdproxy.domain.entities.general.SubjectPersonEntity;

public interface SubjectPersonServiceDAO extends GeneralServiceDAO<SubjectPersonEntity, Long> {
    SubjectPersonEntity getByIIN(String iin) throws NotFound, InvalidInputParameter;
}
