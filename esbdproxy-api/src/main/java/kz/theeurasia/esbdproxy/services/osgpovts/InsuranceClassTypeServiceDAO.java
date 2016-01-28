package kz.theeurasia.esbdproxy.services.osgpovts;

import java.util.Calendar;

import kz.theeurasia.esbdproxy.dict.osgpovts.InsuranceClassTypeDict;
import kz.theeurasia.esbdproxy.domain.IndividualInfo;
import kz.theeurasia.esbdproxy.services.EntityServiceDAO;
import kz.theeurasia.esbdproxy.services.NotFound;

public interface InsuranceClassTypeServiceDAO extends EntityServiceDAO<InsuranceClassTypeDict, Long> {
    InsuranceClassTypeDict getByCode(String code) throws NotFound;

    InsuranceClassTypeDict getForIndividualOnToday(IndividualInfo individual) throws NotFound;

    InsuranceClassTypeDict getForIndividualOnDate(IndividualInfo individual, Calendar date) throws NotFound;

    InsuranceClassTypeDict getDefault();
}
