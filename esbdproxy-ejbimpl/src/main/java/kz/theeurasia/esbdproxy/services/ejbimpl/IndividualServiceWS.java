package kz.theeurasia.esbdproxy.services.ejbimpl;

import javax.ejb.EJB;
import javax.ejb.Singleton;

import kz.theeurasia.asb.esbd.jaxws.ArrayOfClient;
import kz.theeurasia.asb.esbd.jaxws.Client;
import kz.theeurasia.esbdproxy.domain.dict.CountryDict;
import kz.theeurasia.esbdproxy.domain.dict.IdentityCardTypeDict;
import kz.theeurasia.esbdproxy.domain.dict.SexDict;
import kz.theeurasia.esbdproxy.domain.entities.IdentityCardEntity;
import kz.theeurasia.esbdproxy.domain.entities.IndividualEntity;
import kz.theeurasia.esbdproxy.domain.infos.ContactInfo;
import kz.theeurasia.esbdproxy.domain.infos.OriginInfo;
import kz.theeurasia.esbdproxy.domain.infos.PersonalInfo;
import kz.theeurasia.esbdproxy.services.CountryServiceDAO;
import kz.theeurasia.esbdproxy.services.IdentityCardTypeServiceDAO;
import kz.theeurasia.esbdproxy.services.IndividualServiceDAO;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.SexServiceDAO;

@Singleton
public class IndividualServiceWS extends ESBDServiceWS implements IndividualServiceDAO {

    @EJB
    private IdentityCardTypeServiceDAO identityCardTypeService;

    @EJB
    private CountryServiceDAO countryService;

    @EJB
    private SexServiceDAO sexService;

    @Override
    public IndividualEntity getById(Long id) throws NotFound {
	checkSession();

	Client source = getSoapService().getClientByID(getSessionId(), id.intValue());
	if (source == null)
	    throw new NotFound("Not found with ID = '" + id + "'");
	IndividualEntity target = new IndividualEntity();
	fillValues(source, target);
	return target;
    }

    void fillValues(Client source, IndividualEntity target) {
	target.setId(source.getID());

	PersonalInfo pi = new PersonalInfo();
	target.setPersonal(pi);
	pi.setFirstName(source.getFirstName());
	pi.setLastName(source.getLastName());
	pi.setMiddleName(source.getMiddleName());
	pi.setDayOfBirth(convertESBDDateToCalendar(source.getBorn()));

	try {
	    pi.setSex(sexService.getById(new Long(source.getSexID())));
	} catch (NotFound e) {
	    pi.setSex(SexDict.UNSPECIFIED);
	}

	IdentityCardEntity di = new IdentityCardEntity();
	target.setIdentityCardInfo(di);
	di.setDateOfIssue(convertESBDDateToCalendar(source.getDOCUMENTGIVEDDATE()));
	di.setIssuingAuthority(source.getDOCUMENTGIVEDBY());
	di.setNumber(source.getDOCUMENTNUMBER());
	try {
	    di.setIdentityCardType(identityCardTypeService
		    .getById(new Integer(source.getDOCUMENTTYPEID()).longValue()));
	} catch (NotFound e) {
	    di.setIdentityCardType(IdentityCardTypeDict.UNSPECIFIED);
	}

	OriginInfo oi = new OriginInfo();
	target.setOrigin(oi);
	oi.setResident(source.getRESIDENTBOOL() == 1);
	try {
	    oi.setCountry(countryService.getById(new Long(source.getCOUNTRYID())));
	} catch (NotFound e) {
	    oi.setCountry(CountryDict.UNSPECIFIED);
	}

	ContactInfo cni = new ContactInfo();
	target.setContact(cni);
	cni.setPhone(source.getPHONES());
	cni.setHomeAdress(source.getAddress());
	cni.setEmail(source.getEMAIL());

    }

    @Override
    public IndividualEntity getByIDNumber(String idNumber) throws NotFound {
	Client source = fetchClientByIINorDie(idNumber);
	IndividualEntity target = new IndividualEntity();
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
