package kz.theeurasia.esbdproxy.services.general;

import kz.theeurasia.esbdproxy.domain.entities.general.SubjectCompanyEntity;
import kz.theeurasia.esbdproxy.services.GeneralServiceDAO;
import kz.theeurasia.esbdproxy.services.InvalidInputParameter;
import kz.theeurasia.esbdproxy.services.NotFound;

public interface SubjectCompanyServiceDAO extends GeneralServiceDAO<SubjectCompanyEntity, Long> {
    SubjectCompanyEntity getByBIN(String bin) throws NotFound, InvalidInputParameter;
}
