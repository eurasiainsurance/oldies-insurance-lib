package kz.theeurasia.esbdproxy.services.osgpovts;

import java.util.Calendar;
import java.util.List;

import kz.theeurasia.esbdproxy.domain.entities.osgpovts.PolicyEntity;
import kz.theeurasia.esbdproxy.services.GeneralServiceDAO;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.TooMany;

public interface PolicyServiceDAO extends GeneralServiceDAO<PolicyEntity, Long> {
    PolicyEntity getByNumber(String number) throws NotFound;
    List<PolicyEntity> getByPeriodOfDateOfIssue(Calendar from, Calendar till) throws TooMany;
}
