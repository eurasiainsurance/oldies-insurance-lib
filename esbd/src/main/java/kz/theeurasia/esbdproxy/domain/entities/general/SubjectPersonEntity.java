package kz.theeurasia.esbdproxy.domain.entities.general;

import com.lapsa.insurance.elements.SubjectType;

import kz.theeurasia.esbdproxy.domain.infos.general.IdentityCardInfo;
import kz.theeurasia.esbdproxy.domain.infos.general.PersonalInfo;

/**
 * Класс для представления данных о субъекте - физ.лице
 * 
 * @author vadim.isaev
 *
 */
public class SubjectPersonEntity extends SubjectEntity {
    // First_Name s:string Имя (для физ. лица)
    // Last_Name s:string Фамилия (для физ. лица)
    // Middle_Name s:string Отчество (для физ. лица)
    // Born s:string Дата рождения
    // Sex_ID s:int Пол (справочник SEX)
    private PersonalInfo personal = new PersonalInfo();

    // DOCUMENT_TYPE_ID s:int Тип документа (справочник DOCUMENTS_TYPES)
    // DOCUMENT_NUMBER s:string Номер документа
    // DOCUMENT_GIVED_BY s:string Документ выдан
    // DOCUMENT_GIVED_DATE s:string Дата выдачи документа
    private IdentityCardInfo identityCardInfo = new IdentityCardInfo();

    @Override
    public int hashCode() {
	return this.getClass().hashCode() * new Long(getId()).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
	return obj != null && this.getClass().isInstance(obj) && getId() == this.getClass().cast(obj).getId();
    }

    @Override
    public SubjectType getSubjectType() {
	return SubjectType.PERSON;
    }

    // GENERATED

    public PersonalInfo getPersonal() {
	return personal;
    }

    public void setPersonal(PersonalInfo personal) {
	this.personal = personal;
    }

    public IdentityCardInfo getIdentityCard() {
	return identityCardInfo;
    }

    public void setIdentityCardInfo(IdentityCardInfo identityCardInfo) {
	this.identityCardInfo = identityCardInfo;
    }

}
