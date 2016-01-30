package kz.theeurasia.esbdproxy.services.ejbimpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.xml.ws.WebServiceRef;

import kz.theeurasia.asb.esbd.jaxws.IICWebService;
import kz.theeurasia.asb.esbd.jaxws.IICWebServiceSoap;

public abstract class ESBDServiceWS {

    private static final String ESBD_DATE_FORMAT_PATTERN = "dd.MM.yyyy";
    private static final DateFormat ESBD_DATE_FORMATER = new SimpleDateFormat(ESBD_DATE_FORMAT_PATTERN);

    @EJB
    private ESBDWSSession session;

    @WebServiceRef
    private IICWebService esbdService;

    private IICWebServiceSoap soapService;

    @PostConstruct
    protected void initRemoteWS() {
	soapService = esbdService.getIICWebServiceSoap();
	session.checkSession(soapService);
    }

    protected void checkSession() {
	session.checkSession(soapService);
    }

    protected IICWebServiceSoap getSoapService() {
	return soapService;
    }

    protected String getSessionId() {
	return session.getSessionId();
    }

    protected Calendar convertESBDDateToCalendar(String esbdDate) {
	if (esbdDate == null || esbdDate.trim().equals(""))
	    return null;
	try {
	    Calendar date = Calendar.getInstance();
	    date.setTime(ESBD_DATE_FORMATER.parse(esbdDate));
	    return date;
	} catch (ParseException e) {
	    e.printStackTrace();
	    return null;
	}
    }

    protected Date convertESBDDateToDate(String esbdDate) {
	if (esbdDate == null || esbdDate.trim().equals(""))
	    return null;
	try {
	    return ESBD_DATE_FORMATER.parse(esbdDate);
	} catch (ParseException e) {
	    e.printStackTrace();
	    return null;
	}
    }

    protected String convertCalendarToESBDDate(Calendar calendar) {
	if (calendar == null)
	    return null;
	return convertDateToESBDDate(calendar.getTime());
    }

    protected String convertDateToESBDDate(Date date) {
	if (date == null)
	    return null;
	return ESBD_DATE_FORMATER.format(date);
    }
}
