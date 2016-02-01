package kz.theeurasia.esbdproxy.services.general;

import kz.theeurasia.esbdproxy.domain.entities.general.SubjectPersonEntity;
import kz.theeurasia.esbdproxy.services.GeneralServiceDAO;
import kz.theeurasia.esbdproxy.services.NotFound;

public interface SubjectPersonServiceDAO extends GeneralServiceDAO<SubjectPersonEntity, Long> {
    SubjectPersonEntity getByIDNumber(String idNumber) throws NotFound;
}
