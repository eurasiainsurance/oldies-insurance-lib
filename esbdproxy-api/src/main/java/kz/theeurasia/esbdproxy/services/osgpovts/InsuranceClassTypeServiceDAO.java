package kz.theeurasia.esbdproxy.services.osgpovts;

import java.util.Calendar;

import kz.theeurasia.esbdproxy.domain.dict.osgpovts.InsuranceClassTypeDict;
import kz.theeurasia.esbdproxy.domain.entities.SubjectPersonEntity;
import kz.theeurasia.esbdproxy.services.AbstractServiceDAO;
import kz.theeurasia.esbdproxy.services.NotFound;

public interface InsuranceClassTypeServiceDAO extends AbstractServiceDAO<InsuranceClassTypeDict, Long> {
    InsuranceClassTypeDict getByCode(String code) throws NotFound;

    InsuranceClassTypeDict getForIndividualOnToday(SubjectPersonEntity individual) throws NotFound;

    InsuranceClassTypeDict getForIndividualOnDate(SubjectPersonEntity individual, Calendar date) throws NotFound;

    InsuranceClassTypeDict getDefault();
}
