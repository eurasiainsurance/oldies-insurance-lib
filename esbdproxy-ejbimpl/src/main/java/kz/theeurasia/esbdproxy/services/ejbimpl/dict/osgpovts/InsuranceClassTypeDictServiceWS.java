package kz.theeurasia.esbdproxy.services.ejbimpl.dict.osgpovts;

import java.util.Calendar;

import javax.ejb.Singleton;
import javax.xml.ws.soap.SOAPFaultException;

import kz.theeurasia.esbdproxy.domain.dict.osgpovts.InsuranceClassTypeDict;
import kz.theeurasia.esbdproxy.domain.entities.general.SubjectPersonEntity;
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
	    throw new NotFound(InsuranceClassTypeDict.class.getSimpleName() + " not found with ID = '" + id + "'");
	return getByCode(classCode);
    }

    @Override
    public InsuranceClassTypeDict getByCode(String code) throws NotFound {
	InsuranceClassTypeDict result = InsuranceClassTypeDict.forCode(code);
	if (result == null)
	    throw new NotFound(InsuranceClassTypeDict.class.getSimpleName() + " not found with CODE = '" + code + "'");
	return result;
    }

    @Override
    public InsuranceClassTypeDict getForSubjcect(SubjectPersonEntity individual) throws NotFound {
	Calendar today = Calendar.getInstance();
	return getForSubjcect(individual, today);
    }

    @Override
    public InsuranceClassTypeDict getForSubjcect(SubjectPersonEntity subjectPerson, Calendar date)
	    throws NotFound {
	checkSession();
	String esbdDate = convertCalendarToESBDDate(date);
	;
	try {
	    int aClassID = getSoapService().getClassId(getSessionId(), new Long(subjectPerson.getId()).intValue(),
		    esbdDate, 0);
	    if (aClassID == 0)
		throw new NotFound("WS-call getClassId returned zero value for CLIENT_ID = " + subjectPerson.getId()
			+ " and date = " + esbdDate);
	    return getById(new Long(aClassID));
	} catch (SOAPFaultException e) {
	    throw new NotFound("WS-call getClassId returned exception for CLIENT_ID = " + subjectPerson.getId()
		    + " and date = " + esbdDate, e);
	}
    }
}
