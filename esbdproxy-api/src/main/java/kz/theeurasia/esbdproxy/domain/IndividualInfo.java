package kz.theeurasia.esbdproxy.domain;

/**
 * Класс для представления данных о клиенте физ.лице
 * 
 * @author vadim.isaev
 *
 */
public class IndividualInfo {

    private int id;
    private PersonalInfo personal;
    private OriginInfo origin;
    private IdentityCardInfo identityCardInfo;
    private ContactInfo contact;

    public IndividualInfo() {
    }

    public IndividualInfo(int id, PersonalInfo personal, OriginInfo origin, IdentityCardInfo document, ContactInfo contact) {
	this.id = id;
	this.personal = personal;
	this.origin = origin;
	this.identityCardInfo = document;
	this.contact = contact;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
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

    public IdentityCardInfo getIdentityCard() {
	return identityCardInfo;
    }

    public void setIdentityCardInfo(IdentityCardInfo identityCardInfo) {
	this.identityCardInfo = identityCardInfo;
    }

    public ContactInfo getContact() {
	return contact;
    }

    public void setContact(ContactInfo contact) {
	this.contact = contact;
    }

}
