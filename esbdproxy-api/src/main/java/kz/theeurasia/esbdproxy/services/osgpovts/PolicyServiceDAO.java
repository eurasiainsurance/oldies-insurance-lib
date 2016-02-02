package kz.theeurasia.esbdproxy.services.osgpovts;

import kz.theeurasia.esbdproxy.domain.entities.osgpovts.PolicyEntity;
import kz.theeurasia.esbdproxy.services.GeneralServiceDAO;
import kz.theeurasia.esbdproxy.services.NotFound;

public interface PolicyServiceDAO extends GeneralServiceDAO<PolicyEntity, Long> {
    PolicyEntity getByNumber(String number) throws NotFound;
}
