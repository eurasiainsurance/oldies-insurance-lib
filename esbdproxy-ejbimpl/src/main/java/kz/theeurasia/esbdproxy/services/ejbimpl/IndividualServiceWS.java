package kz.theeurasia.esbdproxy.services.ejbimpl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import kz.theeurasia.asb.esbd.jaxws.ArrayOfClient;
import kz.theeurasia.asb.esbd.jaxws.Client;
import kz.theeurasia.esbdproxy.dict.CountryDict;
import kz.theeurasia.esbdproxy.dict.SexDict;
import kz.theeurasia.esbdproxy.domain.ContactInfo;
import kz.theeurasia.esbdproxy.domain.IdentityCardInfo;
import kz.theeurasia.esbdproxy.domain.IdentityCardTypeInfo;
import kz.theeurasia.esbdproxy.domain.IndividualInfo;
import kz.theeurasia.esbdproxy.domain.OriginInfo;
import kz.theeurasia.esbdproxy.domain.PersonalInfo;
import kz.theeurasia.esbdproxy.services.CountryServiceDAO;
import kz.theeurasia.esbdproxy.services.IdentityCardTypeServiceDAO;
import kz.theeurasia.esbdproxy.services.IndividualServiceDAO;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.SexServiceDAO;

@Stateless
public class IndividualServiceWS extends ESBDServiceWS implements IndividualServiceDAO {

    @EJB
    private IdentityCardTypeServiceDAO identityCardTypeService;

    @EJB
    private CountryServiceDAO countryService;

    @EJB
    private SexServiceDAO sexService;

    @Override
    public IndividualInfo getById(Long id) throws NotFound {
	checkSession();

	Client source = getSoapService().getClientByID(getSessionId(), id.intValue());
	IndividualInfo target = new IndividualInfo();
	fillValues(source, target);
	return target;
    }

    void fillValues(Client source, IndividualInfo target) {
	target.setId(source.getID());

	PersonalInfo pi = new PersonalInfo();
	target.setPersonal(pi);
	pi.setFirstName(source.getFirstName());
	pi.setLastName(source.getLastName());
	pi.setMiddleName(source.getMiddleName());
	pi.setDayOfBirth(convertESBDDateToCalendar(source.getBorn()));

	try {
	    SexDict sd = sexService.getById(new Long(source.getSexID()));
	    pi.setSex(sd);
	} catch (NotFound e) {
	    pi.setSex(SexDict.UNSPECIFIED);
	}

	IdentityCardInfo di = new IdentityCardInfo();
	target.setIdentityCardInfo(di);
	di.setDateOfIssue(convertESBDDateToCalendar(source.getDOCUMENTGIVEDDATE()));
	di.setIssuingAuthority(source.getDOCUMENTGIVEDBY());
	di.setNumber(source.getDOCUMENTNUMBER());
	try {
	    IdentityCardTypeInfo dti = identityCardTypeService
		    .getById(new Integer(source.getDOCUMENTTYPEID()).longValue());
	    di.setIdentityCardTypeInfo(dti);
	} catch (NotFound e) {
	}

	OriginInfo oi = new OriginInfo();
	target.setOrigin(oi);
	oi.setResident(source.getRESIDENTBOOL() == 1);
	try {
	    CountryDict ci = countryService.getById(new Long(source.getCOUNTRYID()));
	    oi.setCountry(ci);
	} catch (NotFound e) {
	}

	ContactInfo cni = new ContactInfo();
	target.setContact(cni);
	cni.setPhone(source.getPHONES());
	cni.setHomeAdress(source.getAddress());
	cni.setEmail(source.getEMAIL());

    }

    @Override
    public IndividualInfo getByIDNumber(String idNumber) throws NotFound {
	Client source = fetchClientByIINorDie(idNumber);
	IndividualInfo target = new IndividualInfo();
	fillValues(source, target);
	return target;
    }

    private Client fetchClientByIINorDie(String iin) throws NotFound {
	Client requestClient = new Client();
	requestClient.setNaturalPersonBool(1);
	requestClient.setIIN(iin);

	// ищем среди резидентов
	requestClient.setRESIDENTBOOL(1);
	ArrayOfClient clients = getSoapService().getClientsByKeyFields(getSessionId(), requestClient);
	if (clients != null && clients.getClient() != null && clients.getClient().size() > 0)
	    return clients.getClient().iterator().next();

	// если не нашли, то ищем среди нерезидентов
	requestClient.setRESIDENTBOOL(0);
	clients = getSoapService().getClientsByKeyFields(getSessionId(), requestClient);
	if (clients == null || clients.getClient() == null || clients.getClient().size() == 0)
	    throw new NotFound();
	return clients.getClient().iterator().next();
    }

}
