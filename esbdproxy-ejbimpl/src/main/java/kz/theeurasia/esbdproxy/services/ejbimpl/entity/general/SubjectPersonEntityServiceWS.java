package kz.theeurasia.esbdproxy.services.ejbimpl.entity.general;

import javax.ejb.EJB;
import javax.ejb.Singleton;

import kz.theeurasia.asb.esbd.jaxws.Client;
import kz.theeurasia.esbdproxy.domain.dict.general.IdentityCardTypeDict;
import kz.theeurasia.esbdproxy.domain.dict.general.SexDict;
import kz.theeurasia.esbdproxy.domain.entities.general.SubjectCompanyEntity;
import kz.theeurasia.esbdproxy.domain.entities.general.SubjectEntity;
import kz.theeurasia.esbdproxy.domain.entities.general.SubjectPersonEntity;
import kz.theeurasia.esbdproxy.domain.infos.general.IdentityCardInfo;
import kz.theeurasia.esbdproxy.domain.infos.general.PersonalInfo;
import kz.theeurasia.esbdproxy.services.InvalidInputParameter;
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
    public SubjectPersonEntity getById(Long id) throws NotFound, InvalidInputParameter {
	if (id == null)
	    throw new InvalidInputParameter("ID must be not null");
	checkSession();
	Client source = getSoapService().getClientByID(getSessionId(), id.intValue());
	if (source == null)
	    throw new NotFound(SubjectPersonEntity.class.getSimpleName() + " not found with ID = '" + id + "'");
	boolean isNotPerson = source.getNaturalPersonBool() == 0;
	if (isNotPerson)
	    throw new NotFound(SubjectPersonEntity.class.getSimpleName() + " not found with ID = '" + id
		    + "'. It was a " + SubjectCompanyEntity.class.getName());
	SubjectPersonEntity target = new SubjectPersonEntity();
	fillValues(source, target);
	return target;
    }

    @Override
    public SubjectPersonEntity getByIIN(String iin) throws NotFound, InvalidInputParameter {
	if (iin == null || iin.trim().isEmpty())
	    throw new InvalidInputParameter("'iin' must be not an empty string");
	Client source = fetchClientByIdNumber(iin, true, false);
	if (source == null)
	    throw new NotFound(
		    SubjectPersonEntity.class.getSimpleName() + " not found with 'iin' = '" + iin + "'");
	boolean isNotPerson = source.getNaturalPersonBool() == 0;
	if (isNotPerson)
	    throw new NotFound(SubjectPersonEntity.class.getSimpleName() + " not found with 'iin' = '" + iin
		    + "'. It was a " + SubjectCompanyEntity.class.getName());
	SubjectPersonEntity target = new SubjectPersonEntity();
	fillValues(source, target);
	return target;
    }

    void fillValues(Client source, SubjectPersonEntity target) {
	fillValues(source, (SubjectEntity) target);

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
	} catch (NotFound | InvalidInputParameter e) {
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
	} catch (NotFound | InvalidInputParameter e) {
	    di.setIdentityCardType(IdentityCardTypeDict.UNSPECIFIED);
	}
    }
}
