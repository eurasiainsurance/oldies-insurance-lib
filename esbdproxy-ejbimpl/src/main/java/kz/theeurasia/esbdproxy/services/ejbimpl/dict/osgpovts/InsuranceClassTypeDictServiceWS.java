package kz.theeurasia.esbdproxy.services.ejbimpl.dict.osgpovts;

import java.util.Calendar;

import javax.ejb.Singleton;

import kz.theeurasia.esbdproxy.domain.dict.osgpovts.InsuranceClassTypeDict;
import kz.theeurasia.esbdproxy.domain.entities.SubjectPersonEntity;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.ejbimpl.AbstractESBDServiceWS;
import kz.theeurasia.esbdproxy.services.osgpovts.InsuranceClassTypeServiceDAO;

@Singleton
public class InsuranceClassTypeDictServiceWS extends AbstractESBDServiceWS implements InsuranceClassTypeServiceDAO {

    @Override
    public InsuranceClassTypeDict getById(Long id) throws NotFound {
	checkSession();
	String classCode = getSoapService().getClassText(getSessionId(), new Long(id).intValue());
	if (classCode == null || classCode.trim().equals(""))
	    throw new NotFound("Not found with ID = '" + id + "'");
	return getByCode(classCode);
    }

    @Override
    public InsuranceClassTypeDict getByCode(String code) throws NotFound {
	InsuranceClassTypeDict result = InsuranceClassTypeDict.forCode(code);
	if (result == null)
	    throw new NotFound("Not found with CODE = '" + code + "'");
	return result;
    }

    @Override
    public InsuranceClassTypeDict getForIndividualOnToday(SubjectPersonEntity individual) throws NotFound {
	Calendar today = Calendar.getInstance();
	return getForIndividualOnDate(individual, today);
    }

    @Override
    public InsuranceClassTypeDict getForIndividualOnDate(SubjectPersonEntity individual, Calendar date)
	    throws NotFound {
	checkSession();
	String esbdDate = convertCalendarToESBDDate(date);
	int aClassID = getSoapService().getClassId(getSessionId(), new Long(individual.getId()).intValue(), esbdDate,
		0);
	if (aClassID == 0)
	    throw new NotFound("WS-call getClassId returned zero value for clientId = " + individual.getId()
		    + " and date = " + esbdDate);
	return getById(new Long(aClassID));
    }

    @Override
    public InsuranceClassTypeDict getDefault() {
	// По умолчанию присваивается 3 класс
	return InsuranceClassTypeDict.CLASS_3;
    }

}
