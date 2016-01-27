package kz.theeurasia.services.services.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.xml.ws.WebServiceRef;
import javax.xml.ws.soap.SOAPFaultException;

import kz.theeurasia.asb.esbd.jaxws.ArrayOfClient;
import kz.theeurasia.asb.esbd.jaxws.Client;
import kz.theeurasia.asb.esbd.jaxws.IICWebService;
import kz.theeurasia.asb.esbd.jaxws.IICWebServiceSoap;
import kz.theeurasia.asb.esbd.jaxws.Item;
import kz.theeurasia.asb.esbd.jaxws.User;
import kz.theeurasia.services.domain.esbd.ClientInfo;
import kz.theeurasia.services.domain.esbd.ContactInfo;
import kz.theeurasia.services.domain.esbd.OriginInfo;
import kz.theeurasia.services.domain.esbd.PersonalInfo;
import kz.theeurasia.services.domain.global.IdNumber;
import kz.theeurasia.services.domain.global.InsuranceClassType;
import kz.theeurasia.services.domain.osgpovts.DocumentInfo;
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
    private List<Item> esbdDocTypes;
    private List<Item> esbdCountries;
    private List<Item> esbdSex;

    @PostConstruct
    protected void initRemoteWS() {
	soapService = esbdService.getIICWebServiceSoap();
	checkSession();

	esbdDocTypes = soapService.getItems(aSessionID, "DOCUMENTS_TYPES").getItem();
	esbdCountries = soapService.getItems(aSessionID, "COUNTRIES").getItem();
	esbdSex = soapService.getItems(aSessionID, "SEX").getItem();
	// TODO убрать
	for (Item i : esbdSex) {
	    System.out.println(i.getID() + " " + i.getName());
	}
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

    private Client _findClientByIINorDie(String iin) throws NotFound {
	Client aClient = new Client();
	aClient.setNaturalPersonBool(1);
	aClient.setIIN(iin);

	// ищем среди резидентов
	aClient.setRESIDENTBOOL(1);
	ArrayOfClient clients = soapService.getClientsByKeyFields(aSessionID, aClient);
	if (clients != null && clients.getClient() != null && clients.getClient().size() > 0)
	    return clients.getClient().iterator().next();

	// если не нашли, то ищем среди нерезидентов
	aClient.setRESIDENTBOOL(0);
	clients = soapService.getClientsByKeyFields(aSessionID, aClient);
	if (clients == null || clients.getClient() == null || clients.getClient().size() == 0)
	    throw new NotFound();
	return clients.getClient().iterator().next();
    }

    @Override
    public ClientInfo fetchClient(IdNumber idNumber) throws ESBDException, NotFound, ESBDFaultException {
	try {
	    checkSession();
	    Client cl = _findClientByIINorDie(idNumber.getNumber());

	    ClientInfo ci = new ClientInfo();

	    PersonalInfo pi = new PersonalInfo();
	    ci.setPersonal(pi);

	    pi.setFirstName(cl.getFirstName());
	    pi.setLastName(cl.getLastName());
	    pi.setMiddleName(cl.getMiddleName());
	    pi.setDayOfBirth(_safeConvertDate(cl.getBorn()));

	    DocumentInfo di = new DocumentInfo();
	    ci.setDocument(di);

	    di.setDateOfIssue(_safeConvertDate(cl.getDOCUMENTGIVEDDATE()));
	    di.setIssuingAuthority(cl.getDOCUMENTGIVEDBY());
	    di.setNumber(cl.getDOCUMENTNUMBER());
	    di.setTypeId(cl.getDOCUMENTTYPEID());
	    for (Item i : esbdDocTypes) {
		if (i.getID() == di.getTypeId()) {
		    di.setType(i.getName());
		    break;
		}
	    }

	    OriginInfo oi = new OriginInfo();
	    ci.setOrigin(oi);

	    oi.setResident(cl.getRESIDENTBOOL() == 1);
	    oi.setCountryId(cl.getCOUNTRYID());
	    for (Item i : esbdCountries) {
		if (i.getID() == oi.getCountryId()) {
		    oi.setCountry(i.getName());
		    break;
		}
	    }

	    ContactInfo cni = new ContactInfo();
	    ci.setContact(cni);

	    cni.setPhone(cl.getPHONES());
	    cni.setHomeAdress(cl.getAddress());
	    cni.setEmail(cl.getEMAIL());

	    return ci;
	} catch (SOAPFaultException e) {
	    throw new ESBDFaultException(e);
	}
    }

    private Calendar _safeConvertDate(String esbdDate) {
	try {
	    Calendar date = Calendar.getInstance();
	    date.setTime(ESBD_DATE_FORMATER.parse(esbdDate));
	    return date;
	} catch (ParseException e) {
	    return null;
	}
    }
}
