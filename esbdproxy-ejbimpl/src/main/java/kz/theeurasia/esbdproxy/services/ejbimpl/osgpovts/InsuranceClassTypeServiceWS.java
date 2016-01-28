package kz.theeurasia.esbdproxy.services.ejbimpl.osgpovts;

import java.util.Calendar;

import javax.ejb.Stateless;

import kz.theeurasia.esbdproxy.dict.osgpovts.InsuranceClassTypeDict;
import kz.theeurasia.esbdproxy.domain.IndividualInfo;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.ejbimpl.ESBDServiceWS;
import kz.theeurasia.esbdproxy.services.osgpovts.InsuranceClassTypeServiceDAO;

@Stateless
public class InsuranceClassTypeServiceWS extends ESBDServiceWS implements InsuranceClassTypeServiceDAO {

    @Override
    public InsuranceClassTypeDict getById(Long id) throws NotFound {
	checkSession();
	String classCode = getSoapService().getClassText(getSessionId(), new Long(id).intValue());
	if (classCode == null || classCode.trim().equals(""))
	    throw new NotFound("WS-call getClassText returned null or empty value");
	return getByCode(classCode);
    }

    @Override
    public InsuranceClassTypeDict getByCode(String code) throws NotFound {
	InsuranceClassTypeDict result = InsuranceClassTypeDict.forCode(code);
	if (result == null)
	    throw new NotFound("Class type '" + code + "' is not recognized");
	return result;
    }

    @Override
    public InsuranceClassTypeDict getForIndividualOnToday(IndividualInfo individual) throws NotFound {
	Calendar today = Calendar.getInstance();
	return getForIndividualOnDate(individual, today);
    }

    @Override
    public InsuranceClassTypeDict getForIndividualOnDate(IndividualInfo individual, Calendar date) throws NotFound {
	checkSession();
	String esbdDate = convertCalendarToESBDDate(date);
	int aClassID = getSoapService().getClassId(getSessionId(), individual.getId(), esbdDate, 0);
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
