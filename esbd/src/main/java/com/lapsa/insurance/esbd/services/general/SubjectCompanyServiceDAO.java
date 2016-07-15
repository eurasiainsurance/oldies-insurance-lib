package com.lapsa.insurance.esbd.services.general;

import com.lapsa.insurance.esbd.services.GeneralServiceDAO;
import com.lapsa.insurance.esbd.services.InvalidInputParameter;
import com.lapsa.insurance.esbd.services.NotFound;

import kz.theeurasia.esbdproxy.domain.entities.general.SubjectCompanyEntity;

public interface SubjectCompanyServiceDAO extends GeneralServiceDAO<SubjectCompanyEntity, Long> {
    SubjectCompanyEntity getByBIN(String bin) throws NotFound, InvalidInputParameter;
}
