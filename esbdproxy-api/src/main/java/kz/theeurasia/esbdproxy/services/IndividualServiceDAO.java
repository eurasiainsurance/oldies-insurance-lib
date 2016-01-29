package kz.theeurasia.esbdproxy.services;

import kz.theeurasia.esbdproxy.domain.entities.IndividualEntity;

public interface IndividualServiceDAO extends EntityServiceDAO<IndividualEntity, Long> {
    IndividualEntity getByIDNumber(String idNumber) throws NotFound;
}
