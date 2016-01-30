package kz.theeurasia.esbdproxy.services;

import kz.theeurasia.esbdproxy.domain.entities.SubjectPersonEntity;

public interface SubjectPersonServiceDAO extends AbstractServiceDAO<SubjectPersonEntity, Long> {
    SubjectPersonEntity getByIDNumber(String idNumber) throws NotFound;
}
