package kz.theeurasia.esbdproxy.services;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.entities.CompanyActivityKindEntity;

public interface CompanyActivityKindServiceDAO extends AbstractServiceDAO<CompanyActivityKindEntity, Long> {
    List<CompanyActivityKindEntity> getAll();
}
