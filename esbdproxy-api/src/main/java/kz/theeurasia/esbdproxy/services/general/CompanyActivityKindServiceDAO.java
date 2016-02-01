package kz.theeurasia.esbdproxy.services.general;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.entities.general.CompanyActivityKindEntity;
import kz.theeurasia.esbdproxy.services.GeneralServiceDAO;

public interface CompanyActivityKindServiceDAO extends GeneralServiceDAO<CompanyActivityKindEntity, Long> {
    List<CompanyActivityKindEntity> getAll();
}
