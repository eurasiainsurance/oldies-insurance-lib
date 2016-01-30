package kz.theeurasia.esbdproxy.services;

import kz.theeurasia.esbdproxy.domain.entities.SubjectEntity;

public interface SubjectServiceDAO {
    SubjectEntity getById(Long id) throws NotFound;
}
