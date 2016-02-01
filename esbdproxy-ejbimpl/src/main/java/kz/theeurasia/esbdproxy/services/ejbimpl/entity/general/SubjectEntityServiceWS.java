package kz.theeurasia.esbdproxy.services.ejbimpl.entity.general;

import javax.ejb.EJB;
import javax.ejb.Singleton;

import kz.theeurasia.asb.esbd.jaxws.Client;
import kz.theeurasia.esbdproxy.domain.dict.general.CountryDict;
import kz.theeurasia.esbdproxy.domain.entities.general.SubjectEntity;
import kz.theeurasia.esbdproxy.domain.infos.general.ContactInfo;
import kz.theeurasia.esbdproxy.domain.infos.general.OriginInfo;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.general.CountryServiceDAO;
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

    public SubjectEntity getById(Long id) throws NotFound {
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
	} catch (NotFound e) {
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
    }

}
