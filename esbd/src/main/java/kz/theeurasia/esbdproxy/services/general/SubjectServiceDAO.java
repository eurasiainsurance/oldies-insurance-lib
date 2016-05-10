package kz.theeurasia.esbdproxy.services.general;

import kz.theeurasia.esbdproxy.domain.entities.general.SubjectEntity;
import kz.theeurasia.esbdproxy.services.InvalidInputParameter;
import kz.theeurasia.esbdproxy.services.NotFound;

public interface SubjectServiceDAO {
    SubjectEntity getById(Long id) throws NotFound, InvalidInputParameter;
    SubjectEntity getByIdNumber(String idNumber) throws NotFound, InvalidInputParameter;
}
