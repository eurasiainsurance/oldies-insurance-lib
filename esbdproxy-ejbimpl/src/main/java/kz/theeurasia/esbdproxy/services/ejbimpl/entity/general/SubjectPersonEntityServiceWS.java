package kz.theeurasia.esbdproxy.services.ejbimpl.entity.general;

import javax.ejb.EJB;
import javax.ejb.Singleton;

import kz.theeurasia.asb.esbd.jaxws.ArrayOfClient;
import kz.theeurasia.asb.esbd.jaxws.Client;
import kz.theeurasia.esbdproxy.domain.dict.general.IdentityCardTypeDict;
import kz.theeurasia.esbdproxy.domain.dict.general.SexDict;
import kz.theeurasia.esbdproxy.domain.entities.general.SubjectEntity;
import kz.theeurasia.esbdproxy.domain.entities.general.SubjectPersonEntity;
import kz.theeurasia.esbdproxy.domain.infos.general.IdentityCardInfo;
import kz.theeurasia.esbdproxy.domain.infos.general.PersonalInfo;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.general.IdentityCardTypeServiceDAO;
import kz.theeurasia.esbdproxy.services.general.SexServiceDAO;
import kz.theeurasia.esbdproxy.services.general.SubjectPersonServiceDAO;

@Singleton
public class SubjectPersonEntityServiceWS extends SubjectEntityServiceWS implements SubjectPersonServiceDAO {

    @EJB
    private IdentityCardTypeServiceDAO identityCardTypeService;

    @EJB
    private SexServiceDAO sexService;

    @Override
    public SubjectPersonEntity getById(Long id) throws NotFound {
	checkSession();

	Client source = getSoapService().getClientByID(getSessionId(), id.intValue());
	if (source == null)
	    throw new NotFound(SubjectPersonEntity.class.getSimpleName() + " not found with ID = '" + id + "'");
	SubjectPersonEntity target = new SubjectPersonEntity();
	fillValues(source, (SubjectEntity) target);
	fillValues(source, target);
	return target;
    }

    void fillValues(Client source, SubjectPersonEntity target) {
	// First_Name s:string Имя (для физ. лица)
	// Last_Name s:string Фамилия (для физ. лица)
	// Middle_Name s:string Отчество (для физ. лица)
	// Born s:string Дата рождения
	// Sex_ID s:int Пол (справочник SEX)
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

	// DOCUMENT_TYPE_ID s:int Тип документа (справочник DOCUMENTS_TYPES)
	// DOCUMENT_NUMBER s:string Номер документа
	// DOCUMENT_GIVED_BY s:string Документ выдан
	// DOCUMENT_GIVED_DATE s:string Дата выдачи документа
	IdentityCardInfo di = new IdentityCardInfo();
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
    }

    @Override
    public SubjectPersonEntity getByIDNumber(String idNumber) throws NotFound {
	Client source = fetchClientByIINorDie(idNumber);
	SubjectPersonEntity target = new SubjectPersonEntity();
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
	    throw new NotFound(SubjectPersonEntity.class.getSimpleName() + " not found with IDNumber = '" + iin + "'");
	return clients.getClient().iterator().next();
    }
}
