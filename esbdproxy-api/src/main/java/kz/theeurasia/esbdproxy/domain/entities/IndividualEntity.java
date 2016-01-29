package kz.theeurasia.esbdproxy.domain.entities;

import kz.theeurasia.esbdproxy.domain.infos.ContactInfo;
import kz.theeurasia.esbdproxy.domain.infos.OriginInfo;
import kz.theeurasia.esbdproxy.domain.infos.PersonalInfo;

/**
 * Класс для представления данных о клиенте физ.лице
 * 
 * @author vadim.isaev
 *
 */
public class IndividualEntity extends ClientEntity {

    private PersonalInfo personal;
    private OriginInfo origin;
    private IdentityCardEntity identityCardInfo;
    private ContactInfo contact;

    public IndividualEntity() {
    }

    public IndividualEntity(int id, PersonalInfo personal, OriginInfo origin, IdentityCardEntity document,
	    ContactInfo contact) {
	super(id);
	this.personal = personal;
	this.origin = origin;
	this.identityCardInfo = document;
	this.contact = contact;
    }

    public PersonalInfo getPersonal() {
	return personal;
    }

    public void setPersonal(PersonalInfo personal) {
	this.personal = personal;
    }

    public OriginInfo getOrigin() {
	return origin;
    }

    public void setOrigin(OriginInfo origin) {
	this.origin = origin;
    }

    public IdentityCardEntity getIdentityCard() {
	return identityCardInfo;
    }

    public void setIdentityCardInfo(IdentityCardEntity identityCardInfo) {
	this.identityCardInfo = identityCardInfo;
    }

    public ContactInfo getContact() {
	return contact;
    }

    public void setContact(ContactInfo contact) {
	this.contact = contact;
    }

}
