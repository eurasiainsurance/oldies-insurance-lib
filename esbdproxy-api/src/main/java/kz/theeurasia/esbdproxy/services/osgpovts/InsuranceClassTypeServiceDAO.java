package kz.theeurasia.esbdproxy.services.osgpovts;

import java.util.Calendar;

import kz.theeurasia.esbdproxy.domain.dict.osgpovts.InsuranceClassTypeDict;
import kz.theeurasia.esbdproxy.domain.entities.general.SubjectPersonEntity;
import kz.theeurasia.esbdproxy.services.AbstractServiceDAO;
import kz.theeurasia.esbdproxy.services.NotFound;

public interface InsuranceClassTypeServiceDAO extends AbstractServiceDAO<InsuranceClassTypeDict, Long> {
    InsuranceClassTypeDict getByCode(String code) throws NotFound;

    InsuranceClassTypeDict getForSubjcect(SubjectPersonEntity individual) throws NotFound;

    InsuranceClassTypeDict getForSubjcect(SubjectPersonEntity individual, Calendar date) throws NotFound;
}
