package com.lapsa.insurance.esbd.services.general;

import java.util.List;

import com.lapsa.insurance.esbd.services.GeneralServiceDAO;

import kz.theeurasia.esbdproxy.domain.entities.general.CompanyActivityKindEntity;

public interface CompanyActivityKindServiceDAO extends GeneralServiceDAO<CompanyActivityKindEntity, Long> {
    List<CompanyActivityKindEntity> getAll();
}
