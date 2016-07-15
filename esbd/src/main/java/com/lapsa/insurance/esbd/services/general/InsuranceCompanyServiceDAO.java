package com.lapsa.insurance.esbd.services.general;

import java.util.List;

import com.lapsa.insurance.esbd.services.GeneralServiceDAO;

import kz.theeurasia.esbdproxy.domain.entities.general.InsuranceCompanyEntity;

public interface InsuranceCompanyServiceDAO extends GeneralServiceDAO<InsuranceCompanyEntity, Long> {
    List<InsuranceCompanyEntity> getAll();
}
