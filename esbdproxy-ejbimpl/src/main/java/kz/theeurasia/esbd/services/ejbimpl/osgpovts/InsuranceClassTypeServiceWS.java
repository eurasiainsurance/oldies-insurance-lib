package kz.theeurasia.esbd.services.ejbimpl.osgpovts;

import java.util.Calendar;

import javax.ejb.Stateless;

import kz.theeurasia.esbd.domain.ClientInfo;
import kz.theeurasia.esbd.domain.osgpovts.InsuranceClassType;
import kz.theeurasia.esbd.services.NotFound;
import kz.theeurasia.esbd.services.ejbimpl.ESBDServiceWS;
import kz.theeurasia.esbd.services.osgpovts.InsuranceClassTypeServiceDAO;

@Stateless
public class InsuranceClassTypeServiceWS extends ESBDServiceWS implements InsuranceClassTypeServiceDAO {

    @Override
    public InsuranceClassType getById(Long id) throws NotFound {
	checkSession();
	String classCode = getSoapService().getClassText(getSessionId(), new Long(id).intValue());
	if (classCode == null || classCode.trim().equals(""))
	    throw new NotFound("WS-call getClassText returned null or empty value");
	return getByCode(classCode);
    }

    @Override
    public InsuranceClassType getByCode(String code) throws NotFound {
	InsuranceClassType result = InsuranceClassType.forCode(code);
	if (result == null)
	    throw new NotFound("Class type '" + code + "' is not recognized");
	return result;
    }

    @Override
    public InsuranceClassType getForClientOnToday(ClientInfo client) throws NotFound {
	Calendar today = Calendar.getInstance();
	return getForClientOnDate(client, today);
    }

    @Override
    public InsuranceClassType getForClientOnDate(ClientInfo client, Calendar date) throws NotFound {
	checkSession();
	String esbdDate = convertCalendarToESBDDate(date);
	int aClassID = getSoapService().getClassId(getSessionId(), client.getId(), esbdDate, 0);
	if (aClassID == 0)
	    throw new NotFound("WS-call getClassId returned zero value for clientId = " + client.getId()
		    + " and date = " + esbdDate);
	return getById(new Long(aClassID));
    }

    @Override
    public InsuranceClassType getDefault() {
	// По умолчанию присваивается 3 класс
	return InsuranceClassType.CLASS_3;
    }

}
