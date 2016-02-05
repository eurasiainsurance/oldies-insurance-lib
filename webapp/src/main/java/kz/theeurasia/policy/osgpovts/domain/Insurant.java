package kz.theeurasia.policy.osgpovts.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.primefaces.model.UploadedFile;

import kz.theeurasia.esbdproxy.domain.dict.general.EconomicSectorDict;
import kz.theeurasia.esbdproxy.domain.dict.general.IdentityCardTypeDict;
import kz.theeurasia.esbdproxy.domain.entities.general.SubjectPersonEntity;
import kz.theeurasia.esbdproxy.domain.infos.general.ContactInfo;
import kz.theeurasia.esbdproxy.domain.infos.general.IdentityCardInfo;
import kz.theeurasia.esbdproxy.domain.infos.general.OriginInfo;
import kz.theeurasia.esbdproxy.domain.infos.general.PersonalInfo;

public class Insurant {
    private final UUID id = UUID.randomUUID();

    private String idNumber = "";

    private final PersonalInfo personal = new PersonalInfo();
    private final OriginInfo origin = new OriginInfo();

    private final IdentityCardInfo identityCard = new IdentityCardInfo();
    private IdentityCardTypeDict identityCardType = IdentityCardTypeDict.ID_CARD;
    private final List<UploadedFile> identityCardDocuments = new ArrayList<>();

    private ContactInfo contact = new ContactInfo();

    private String taxPayerNumber = "";

    private boolean resident;

    private final EconomicSectorDict economicsSector = EconomicSectorDict.HOUSEHOLDS;

    // esbd entities
    private SubjectPersonEntity fetchedEntity;

    @Override
    public int hashCode() {
	return this.getClass().hashCode() * id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
	return obj != null && this.getClass().isInstance(obj) && getId().equals((this.getClass().cast(obj)).getId());
    }

    public String getSafeId() {
	return id.toString().replaceAll("-", "_");
    }

    // GENERATED

    public UUID getId() {
	return id;
    }

    public String getIdNumber() {
	return idNumber;
    }

    public void setIdNumber(String idNumber) {
	this.idNumber = idNumber;
    }

    public IdentityCardTypeDict getIdentityCardType() {
	return identityCardType;
    }

    public void setIdentityCardType(IdentityCardTypeDict identityCardType) {
	this.identityCardType = identityCardType;
    }

    public ContactInfo getContact() {
	return contact;
    }

    public void setContact(ContactInfo contact) {
	this.contact = contact;
    }

    public String getTaxPayerNumber() {
	return taxPayerNumber;
    }

    public void setTaxPayerNumber(String taxPayerNumber) {
	this.taxPayerNumber = taxPayerNumber;
    }

    public boolean isResident() {
	return resident;
    }

    public void setResident(boolean resident) {
	this.resident = resident;
    }

    public SubjectPersonEntity getFetchedEntity() {
	return fetchedEntity;
    }

    public void setFetchedEntity(SubjectPersonEntity fetchedEntity) {
	this.fetchedEntity = fetchedEntity;
    }

    public PersonalInfo getPersonal() {
	return personal;
    }

    public OriginInfo getOrigin() {
	return origin;
    }

    public IdentityCardInfo getIdentityCard() {
	return identityCard;
    }

    public List<UploadedFile> getIdentityCardDocuments() {
	return identityCardDocuments;
    }

    public EconomicSectorDict getEconomicsSector() {
	return economicsSector;
    }

}
