package kz.theeurasia.policy.domain;

import java.util.UUID;

import com.lapsa.kz.economic.KZEconomicSector;
import com.lapsa.kz.idnumber.validators.ValidIdNumber;

import kz.theeurasia.policy.validator.NotNullValue;
import kz.theeurasia.policy.validator.ValidEnumerationValue;

public class InsurantData {
    private final UUID id = UUID.randomUUID();

    @NotNullValue
    @ValidIdNumber
    private String idNumber;

    private String taxPayerNumber;

    private PersonalData personalData = new PersonalData();
    private OriginData originData = new OriginData();
    private ResidenceData residenceData = new ResidenceData();
    private ContactData contactData = new ContactData();

    private IdentityCardData identityCardData = new IdentityCardData();

    private KZEconomicSector economicsSector = KZEconomicSector.HOUSEHOLDS;

    @NotNullValue(message = "{kz.theeurasia.policy.validator.custom.DriverAsInsurant.message}")
    private InsuredDriverData driverAsInsurant;

    @NotNullValue(message = "{kz.theeurasia.policy.validator.custom.WhoIsInsurant.message}")
    @ValidEnumerationValue(message = "{kz.theeurasia.policy.validator.custom.WhoIsInsurant.message}")
    private WhoIsInsurant whoIsInsurant = WhoIsInsurant.UNSPECIFIED;

    private boolean fetched = false;

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

    @Override
    public String toString() {
	return personalData.getDisplayName();
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

    public ContactData getContactData() {
	return contactData;
    }

    public void setContactData(ContactData contactData) {
	this.contactData = contactData;
    }

    public IdentityCardData getIdentityCardData() {
	return identityCardData;
    }

    public void setIdentityCardData(IdentityCardData identityCardData) {
	this.identityCardData = identityCardData;
    }

    public KZEconomicSector getEconomicsSector() {
	return economicsSector;
    }

    public void setEconomicsSector(KZEconomicSector economicsSector) {
	this.economicsSector = economicsSector;
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

    public WhoIsInsurant getWhoIsInsurant() {
	return whoIsInsurant;
    }

    public void setWhoIsInsurant(WhoIsInsurant whoIsInsurant) {
	this.whoIsInsurant = whoIsInsurant;
    }

    public boolean isFetched() {
	return fetched;
    }

    public void setFetched(boolean fetched) {
	this.fetched = fetched;
    }
}
