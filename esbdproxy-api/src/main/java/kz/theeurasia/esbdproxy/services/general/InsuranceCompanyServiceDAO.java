package kz.theeurasia.esbdproxy.services.general;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.entities.general.InsuranceCompanyEntity;
import kz.theeurasia.esbdproxy.services.AbstractServiceDAO;

public interface InsuranceCompanyServiceDAO extends AbstractServiceDAO<InsuranceCompanyEntity, Long> {
    List<InsuranceCompanyEntity> getAll();
}
