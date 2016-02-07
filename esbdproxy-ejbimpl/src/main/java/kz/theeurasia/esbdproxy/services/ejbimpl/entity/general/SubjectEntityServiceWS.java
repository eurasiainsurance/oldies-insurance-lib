package kz.theeurasia.esbdproxy.services.ejbimpl.entity.general;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;

import kz.theeurasia.asb.esbd.jaxws.ArrayOfClient;
import kz.theeurasia.asb.esbd.jaxws.Client;
import kz.theeurasia.esbdproxy.domain.dict.general.CountryDict;
import kz.theeurasia.esbdproxy.domain.entities.general.SubjectEntity;
import kz.theeurasia.esbdproxy.domain.infos.general.ContactInfo;
import kz.theeurasia.esbdproxy.domain.infos.general.OriginInfo;
import kz.theeurasia.esbdproxy.services.InvalidInputParameter;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.ejbimpl.DataCoruptionException;
import kz.theeurasia.esbdproxy.services.general.CountryServiceDAO;
import kz.theeurasia.esbdproxy.services.general.EconomicSectorServiceDAO;
import kz.theeurasia.esbdproxy.services.general.SubjectCompanyServiceDAO;
import kz.theeurasia.esbdproxy.services.general.SubjectPersonServiceDAO;
import kz.theeurasia.esbdproxy.services.general.SubjectServiceDAO;

@Singleton
public class SubjectEntityServiceWS extends AbstractESBDEntityServiceWS implements SubjectServiceDAO {

    @EJB
    private SubjectPersonServiceDAO subjectPersonService;

    @EJB
    private SubjectCompanyServiceDAO subjectCompanyService;

    @EJB
    private CountryServiceDAO countryService;

    @EJB
    private EconomicSectorServiceDAO econimicsSectorService;

    public SubjectEntity getById(Long id) throws NotFound, InvalidInputParameter {
	if (id == null)
	    throw new InvalidInputParameter("ID must be not null");
	checkSession();
	Client source = getSoapService().getClientByID(getSessionId(), id.intValue());
	if (source == null)
	    throw new NotFound(SubjectEntity.class.getSimpleName() + " not found with ID = '" + id + "'");

	if (source.getNaturalPersonBool() == 1) {
	    // частник SubjectPerson
	    return subjectPersonService.getById(id);
	} else {
	    // юрлицо SubjectCompany
	    return subjectCompanyService.getById(id);
	}
    }

    @Override
    public SubjectEntity getByIdNumber(String idNumber) throws NotFound, InvalidInputParameter {
	if (idNumber == null || idNumber.trim().isEmpty())
	    throw new InvalidInputParameter("'idNumber' must be not an empty string");
	Client source = fetchClientByIdNumber(idNumber, true, true);
	if (source == null)
	    throw new NotFound(SubjectEntity.class.getSimpleName() + " not found with IDNumber = '" + idNumber + "'");
	if (source.getNaturalPersonBool() == 1) {
	    // частник SubjectPerson
	    return subjectPersonService.getByIIN(idNumber);
	} else {
	    // юрлицо SubjectCompany
	    return subjectCompanyService.getByBIN(idNumber);
	}
    }

    protected Client fetchClientByIdNumber(String idNumber, boolean fetchNaturals, boolean fetchCompanies) {
	int[] residentBools = new int[] { 1, 0 };
	List<Integer> naturalPersonBools = new ArrayList<>();
	if (fetchNaturals)
	    naturalPersonBools.add(1);
	if (fetchCompanies)
	    naturalPersonBools.add(0);
	checkSession();
	for (int residentBool : residentBools) {
	    for (int naturalPersonBool : naturalPersonBools) {
		Client requestClient = new Client();
		requestClient.setIIN(idNumber);
		requestClient.setNaturalPersonBool(naturalPersonBool);
		requestClient.setRESIDENTBOOL(residentBool);
		ArrayOfClient clients = getSoapService().getClientsByKeyFields(getSessionId(), requestClient);
		if (clients != null && clients.getClient() != null && clients.getClient().size() > 0)
		    return clients.getClient().iterator().next();
	    }
	}
	return null;
    }

    void fillValues(Client source, SubjectEntity target) {
	// ID s:int Идентификатор клиента (обязательно)
	target.setId(source.getID());

	// RESIDENT_BOOL s:int Признак резидентства (обязательно)
	// COUNTRY_ID s:int Страна (справочник COUNTRIES)
	// SETTLEMENT_ID s:int Населенный пункт (справочник SETTLEMENTS)
	OriginInfo oi = new OriginInfo();
	target.setOrigin(oi);
	oi.setResident(source.getRESIDENTBOOL() == 1);
	try {
	    oi.setCountry(countryService.getById(new Long(source.getCOUNTRYID())));
	} catch (NotFound | InvalidInputParameter e) {
	    oi.setCountry(CountryDict.UNSPECIFIED);
	}

	// PHONES s:string Номера телефонов
	// EMAIL s:string Адрес электронной почты
	// Address s:string Адрес
	// WWW s:string Сайт
	ContactInfo cni = new ContactInfo();
	target.setContact(cni);
	cni.setPhone(source.getPHONES());
	cni.setEmail(source.getEMAIL());
	cni.setHomeAdress(source.getAddress());
	cni.setSiteUrl(source.getWWW());

	// TPRN s:string РНН
	target.setTaxPayerNumber(source.getTPRN());

	// DESCRIPTION s:string Примечание
	target.setComments(source.getDESCRIPTION());

	// RESIDENT_BOOL s:int Признак резидентства (обязательно)
	target.setResident(source.getRESIDENTBOOL() == 1);

	// IIN s:string ИИН/БИН
	target.setIdNumber(source.getIIN());

	// ECONOMICS_SECTOR_ID s:int Сектор экономики (справочник
	// ECONOMICS_SECTORS)
	try {
	    target.setEconomicsSector(econimicsSectorService.getById(new Long(source.getECONOMICSSECTORID())));
	} catch (NotFound | InvalidInputParameter e) {
	    // mandatory field
	    throw new DataCoruptionException(
		    "Error while fetching Company Client ID = '" + source.getID()
			    + "' from ESBD. Economics Sector ID = '"
			    + source.getECONOMICSSECTORID() + "' not found",
		    e);
	}
    }

}
