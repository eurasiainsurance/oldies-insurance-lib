package kz.theeurasia.policy.domain;

import java.util.UUID;

import kz.theeurasia.esbdproxy.domain.dict.general.EconomicSectorDict;
import kz.theeurasia.esbdproxy.domain.entities.general.SubjectPersonEntity;
import kz.theeurasia.policy.validator.NotNullValue;
import kz.theeurasia.policy.validator.ValidIdNumber;

public class InsurantData {
    private final UUID id = UUID.randomUUID();

    @NotNullValue
    @ValidIdNumber
    private String idNumber;

    private String taxPayerNumber;

    private PersonalData personalData = new PersonalData();
    private OriginData originData = new OriginData();
    private ResidenceData residenceData = new ResidenceData();
    private ContactData contact = new ContactData();

    private IdentityCardData identityCardData = new IdentityCardData();

    private EconomicSectorDict economicsSector = EconomicSectorDict.HOUSEHOLDS;

    private boolean insurantADriver;
    private InsuredDriverData driverAsInsurant;

    private SubjectPersonEntity fetchedEntity;

    private boolean readyToFill;

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

    public String getTaxPayerNumber() {
	return taxPayerNumber;
    }

    public void setTaxPayerNumber(String taxPayerNumber) {
	this.taxPayerNumber = taxPayerNumber;
    }

    public PersonalData getPersonalData() {
	return personalData;
    }

    public void setPersonalData(PersonalData personalData) {
	this.personalData = personalData;
    }

    public OriginData getOriginData() {
	return originData;
    }

    public void setOriginData(OriginData originData) {
	this.originData = originData;
    }

    public ContactData getContact() {
	return contact;
    }

    public void setContact(ContactData contact) {
	this.contact = contact;
    }

    public IdentityCardData getIdentityCardData() {
	return identityCardData;
    }

    public void setIdentityCardData(IdentityCardData identityCardData) {
	this.identityCardData = identityCardData;
    }

    public EconomicSectorDict getEconomicsSector() {
	return economicsSector;
    }

    public void setEconomicsSector(EconomicSectorDict economicsSector) {
	this.economicsSector = economicsSector;
    }

    public boolean isInsurantADriver() {
	return insurantADriver;
    }

    public void setInsurantADriver(boolean insurantADriver) {
	this.insurantADriver = insurantADriver;
    }

    public InsuredDriverData getDriverAsInsurant() {
	return driverAsInsurant;
    }

    public void setDriverAsInsurant(InsuredDriverData driverAsInsurant) {
	this.driverAsInsurant = driverAsInsurant;
    }

    public ResidenceData getResidenceData() {
	return residenceData;
    }

    public void setResidenceData(ResidenceData residenceData) {
	this.residenceData = residenceData;
    }

    public boolean isReadyToFill() {
	return readyToFill;
    }

    public void setReadyToFill(boolean readyToFill) {
	this.readyToFill = readyToFill;
    }

    public SubjectPersonEntity getFetchedEntity() {
	return fetchedEntity;
    }

    public void setFetchedEntity(SubjectPersonEntity fetchedEntity) {
	this.fetchedEntity = fetchedEntity;
    }

}
