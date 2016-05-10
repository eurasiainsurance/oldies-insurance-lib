package kz.theeurasia.esbdproxy.services.general;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.entities.general.InsuranceCompanyEntity;
import kz.theeurasia.esbdproxy.services.GeneralServiceDAO;

public interface InsuranceCompanyServiceDAO extends GeneralServiceDAO<InsuranceCompanyEntity, Long> {
    List<InsuranceCompanyEntity> getAll();
}
