package kz.theeurasia.esbdproxy.services.osgpovts;

import java.util.Calendar;

import kz.theeurasia.esbdproxy.domain.dict.osgpovts.InsuranceClassTypeDict;
import kz.theeurasia.esbdproxy.domain.entities.general.SubjectPersonEntity;
import kz.theeurasia.esbdproxy.services.GeneralServiceDAO;
import kz.theeurasia.esbdproxy.services.InvalidInputParameter;
import kz.theeurasia.esbdproxy.services.NotFound;

public interface InsuranceClassTypeServiceDAO extends GeneralServiceDAO<InsuranceClassTypeDict, Long> {
    InsuranceClassTypeDict getByCode(String code) throws NotFound, InvalidInputParameter;

    InsuranceClassTypeDict getForSubject(SubjectPersonEntity individual) throws NotFound, InvalidInputParameter;

    InsuranceClassTypeDict getForSubject(SubjectPersonEntity individual, Calendar date) throws NotFound, InvalidInputParameter;

    InsuranceClassTypeDict getDefault();
}
