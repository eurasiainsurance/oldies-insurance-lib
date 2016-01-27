package kz.theeurasia.services.services.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.xml.ws.WebServiceRef;
import javax.xml.ws.soap.SOAPFaultException;

import kz.theeurasia.asb.esbd.jaxws.ArrayOfClient;
import kz.theeurasia.asb.esbd.jaxws.Client;
import kz.theeurasia.asb.esbd.jaxws.IICWebService;
import kz.theeurasia.asb.esbd.jaxws.IICWebServiceSoap;
import kz.theeurasia.asb.esbd.jaxws.User;
import kz.theeurasia.services.domain.esbd.ClientInfo;
import kz.theeurasia.services.domain.global.IdNumber;
import kz.theeurasia.services.domain.global.InsuranceClassType;
import kz.theeurasia.services.services.ESBDAccess;
import kz.theeurasia.services.services.ESBDException;
import kz.theeurasia.services.services.ESBDFaultException;
import kz.theeurasia.services.services.NotFound;

@Singleton
public class ESBDAccessImplementation implements ESBDAccess {
    private static final String ESBD_DATE_FORMAT_PATTERN = "dd.MM.yyyy";
    private static final DateFormat ESBD_DATE_FORMATER = new SimpleDateFormat(ESBD_DATE_FORMAT_PATTERN);
    private static final String ESBD_WS_USER_NAME = "EUR.SSL.GORDOVA";
    private static final String ESBD_WS_USER_PASSWORD = "Be$tKe7";

    private Logger logger = Logger.getAnonymousLogger();

    @WebServiceRef
    private IICWebService esbdService;

    private String aSessionID;
    private IICWebServiceSoap soapService;

    @PostConstruct
    protected void initRemoteWS() {
	soapService = esbdService.getIICWebServiceSoap();
	checkSession();
    }

    private void checkSession() {
	if (aSessionID == null || aSessionID.equals("") || !soapService.sessionExists(aSessionID, ESBD_WS_USER_NAME)) {
	    logger.fine("Establishing new ESBD session for user " + ESBD_WS_USER_NAME);
	    User user = soapService.authenticateUser(ESBD_WS_USER_NAME, ESBD_WS_USER_PASSWORD);
	    aSessionID = user.getSessionID();
	    logger.fine("ESBD session established aSessionID = " + aSessionID);
	}
    }

    @Override
    public InsuranceClassType getInsuranceClassTypeForIndividual(IdNumber idNumber)
	    throws ESBDException, ESBDFaultException {
	try {
	    checkSession();
	    Client aClient = new Client();
	    aClient.setNaturalPersonBool(1);
	    aClient.setRESIDENTBOOL(1);
	    aClient.setIIN(idNumber.getNumber());
	    ArrayOfClient clients;

	    clients = soapService.getClientsByKeyFields(aSessionID, aClient);

	    if (clients == null || clients.getClient() == null || clients.getClient().size() == 0)
		return InsuranceClassType.DEFAULT; // возращаем класс по
						   // умолчанию
						   // только если в ЕСБД нет
						   // такого
						   // клиента
	    if (clients.getClient().size() > 1)
		throw new ESBDException("Too many clients found with IIN = " + idNumber.getNumber());
	    Calendar now = Calendar.getInstance();
	    int aClassID = soapService.getClassId(aSessionID, clients.getClient().iterator().next().getID(),
		    ESBD_DATE_FORMATER.format(now.getTime()), 0);
	    if (aClassID == 0)
		throw new ESBDException("WS-call getClassId returned zero value");
	    String aClassText = soapService.getClassText(aSessionID, aClassID);
	    if (aClassText == null || aClassText.trim().equals(""))
		throw new ESBDException("WS-call getClassText returned null or empty value");
	    InsuranceClassType classType = InsuranceClassType.forCode(aClassText);
	    if (classType == null)
		throw new ESBDException("Class type '" + classType + "' is not recognized");
	    return classType;
	} catch (SOAPFaultException e) {
	    throw new ESBDFaultException(e);
	}
    }

    @Override
    public ClientInfo getClientInfo(IdNumber idNumber) throws ESBDException, NotFound, ESBDFaultException {
	try {
	    checkSession();
	    Client aClient = new Client();
	    aClient.setNaturalPersonBool(1);
	    aClient.setRESIDENTBOOL(1);
	    aClient.setIIN(idNumber.getNumber());
	    checkSession();
	    ArrayOfClient clients = soapService.getClientsByKeyFields(aSessionID, aClient);
	    if (clients == null || clients.getClient() == null || clients.getClient().size() == 0)
		throw new NotFound();
	    Client cl = clients.getClient().iterator().next();
	    ClientInfo ci = new ClientInfo();
	    ci.setFirstName(cl.getFirstName());
	    ci.setLastName(cl.getLastName());
	    ci.setMiddleName(cl.getMiddleName());
	    ci.setEmail(cl.getEMAIL());
	    ci.setAddress(cl.getAddress());
	    return ci;
	} catch (SOAPFaultException e) {
	    throw new ESBDFaultException(e);
	}
    }
}
