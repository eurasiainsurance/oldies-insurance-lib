package kz.theeurasia.esbd.domain;

/**
 * Класс для представления данных о клиенте физ.лице
 * 
 * @author vadim.isaev
 *
 */
public class ClientInfo {

    private int id;
    private PersonalInfo personal;
    private OriginInfo origin;
    private DocumentInfo document;
    private ContactInfo contact;

    public ClientInfo() {
    }

    public ClientInfo(int id, PersonalInfo personal, OriginInfo origin, DocumentInfo document, ContactInfo contact) {
	this.id = id;
	this.personal = personal;
	this.origin = origin;
	this.document = document;
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

    public DocumentInfo getDocument() {
	return document;
    }

    public void setDocument(DocumentInfo document) {
	this.document = document;
    }

    public ContactInfo getContact() {
	return contact;
    }

    public void setContact(ContactInfo contact) {
	this.contact = contact;
    }

}
