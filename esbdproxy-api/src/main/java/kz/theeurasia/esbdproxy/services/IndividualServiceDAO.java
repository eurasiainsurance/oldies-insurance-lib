package kz.theeurasia.esbdproxy.services;

import kz.theeurasia.esbdproxy.domain.IndividualInfo;

public interface IndividualServiceDAO extends EntityServiceDAO<IndividualInfo, Long> {
    IndividualInfo getByIDNumber(String idNumber) throws NotFound;
}
