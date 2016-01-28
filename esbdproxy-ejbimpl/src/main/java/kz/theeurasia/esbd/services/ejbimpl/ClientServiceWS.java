package kz.theeurasia.esbd.services.ejbimpl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import kz.theeurasia.asb.esbd.jaxws.ArrayOfClient;
import kz.theeurasia.asb.esbd.jaxws.Client;
import kz.theeurasia.esbd.domain.ClientInfo;
import kz.theeurasia.esbd.domain.ContactInfo;
import kz.theeurasia.esbd.domain.CountryInfo;
import kz.theeurasia.esbd.domain.DocumentInfo;
import kz.theeurasia.esbd.domain.DocumentTypeInfo;
import kz.theeurasia.esbd.domain.OriginInfo;
import kz.theeurasia.esbd.domain.PersonalInfo;
import kz.theeurasia.esbd.services.ClientServiceDAO;
import kz.theeurasia.esbd.services.CountryServiceDAO;
import kz.theeurasia.esbd.services.DocumentTypeServiceDAO;
import kz.theeurasia.esbd.services.NotFound;

@Stateless
public class ClientServiceWS extends ESBDServiceWS implements ClientServiceDAO {

    @EJB
    private DocumentTypeServiceDAO documentTypeService;

    @EJB
    private CountryServiceDAO countryService;

    @Override
    public ClientInfo getById(Long id) throws NotFound {
	checkSession();

	Client source = getSoapService().getClientByID(getSessionId(), id.intValue());
	ClientInfo target = new ClientInfo();
	fillValues(source, target);
	return target;
    }

    void fillValues(Client source, ClientInfo target) {
	target.setId(source.getID());

	PersonalInfo pi = new PersonalInfo();
	target.setPersonal(pi);
	pi.setFirstName(source.getFirstName());
	pi.setLastName(source.getLastName());
	pi.setMiddleName(source.getMiddleName());
	pi.setDayOfBirth(convertESBDDateToCalendar(source.getBorn()));

	DocumentInfo di = new DocumentInfo();
	target.setDocument(di);
	di.setDateOfIssue(convertESBDDateToCalendar(source.getDOCUMENTGIVEDDATE()));
	di.setIssuingAuthority(source.getDOCUMENTGIVEDBY());
	di.setNumber(source.getDOCUMENTNUMBER());
	try {
	    DocumentTypeInfo dti = documentTypeService.getById(new Integer(source.getDOCUMENTTYPEID()).longValue());
	    di.setDocumentType(dti);
	} catch (NotFound e) {
	}

	OriginInfo oi = new OriginInfo();
	target.setOrigin(oi);
	oi.setResident(source.getRESIDENTBOOL() == 1);
	try {
	    CountryInfo ci = countryService.getById(new Integer(source.getCOUNTRYID()).longValue());
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
    public ClientInfo getByIDNumber(String idNumber) throws NotFound {
	Client source = fetchClientByIINorDie(idNumber);
	ClientInfo target = new ClientInfo();
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
