package kz.theeurasia.esbdproxy.services;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.entities.InsuranceCompanyEntity;

public interface InsuranceCompanyServiceDAO extends AbstractServiceDAO<InsuranceCompanyEntity, Long> {
    List<InsuranceCompanyEntity> getAll();
}
