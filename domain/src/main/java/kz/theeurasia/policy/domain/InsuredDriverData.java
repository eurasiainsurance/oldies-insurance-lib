package kz.theeurasia.policy.domain;

import java.util.UUID;

import kz.theeurasia.esbdproxy.domain.dict.osgpovts.InsuranceClassTypeDict;
import kz.theeurasia.esbdproxy.domain.enums.osgpovts.InsuredAgeClassEnum;
import kz.theeurasia.esbdproxy.domain.enums.osgpovts.InsuredExpirienceClassEnum;
import kz.theeurasia.policy.validator.ValidIdNumber;
import kz.theeurasia.policy.validator.ValidInsuranceAgeClass;
import kz.theeurasia.policy.validator.ValidInsuranceExpirienceClass;
import kz.theeurasia.policy.validator.NotNullValue;

public class InsuredDriverData {
    private final UUID id = UUID.randomUUID();

    private InsuranceClassTypeDict insuranceClassType;

    @NotNullValue(message = "{kz.theeurasia.policy.validator.custom.IdNumber.empty.message}")
    @ValidIdNumber
    private String idNumber;

    private String taxPayerNumber;

    private PersonalData personalData = new PersonalData();
    private OriginData originData = new OriginData();
    private ResidenceData residenceData = new ResidenceData();
    private IdentityCardData identityCardData = new IdentityCardData();
    private DriverLicenseData driverLicenseData = new DriverLicenseData();
    private ContactData contactData = new ContactData();

    @NotNullValue
    @ValidInsuranceAgeClass
    private InsuredAgeClassEnum ageClass;

    @NotNullValue
    @ValidInsuranceExpirienceClass
    private InsuredExpirienceClassEnum expirienceClass;

    private boolean fetched = false;

    // privileges
    private boolean hasAnyPrivilege = false;

    private boolean priveleger = false;
    private PrivilegerCertificateData privilegerCertificateData = new PrivilegerCertificateData();

    private boolean handicaped = false;
    private HandicaptedCertificateData handicapedCertificateData = new HandicaptedCertificateData();

    private boolean gpwParticipant = false;
    private GPWParticipantCertificateData gpwParticipantCertificateData = new GPWParticipantCertificateData();

    private boolean pensioner = false;
    private PensionerCertificateData pensionerCertificateData = new PensionerCertificateData();

    @Override
    public int hashCode() {
	return this.getClass().hashCode() * id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
	return obj != null && this.getClass().isInstance(obj) && getId().equals((this.getClass().cast(obj)).getId());
    }

    public String getDisplayName() {
	return personalData.getDisplayName();
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

    public InsuranceClassTypeDict getInsuranceClassType() {
	return insuranceClassType;
    }

    public void setInsuranceClassType(InsuranceClassTypeDict insuranceClassType) {
	this.insuranceClassType = insuranceClassType;
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

    public ResidenceData getResidenceData() {
	return residenceData;
    }

    public void setResidenceData(ResidenceData residenceData) {
	this.residenceData = residenceData;
    }

    public IdentityCardData getIdentityCardData() {
	return identityCardData;
    }

    public void setIdentityCardData(IdentityCardData identityCardData) {
	this.identityCardData = identityCardData;
    }

    public DriverLicenseData getDriverLicenseData() {
	return driverLicenseData;
    }

    public void setDriverLicenseData(DriverLicenseData driverLicenseData) {
	this.driverLicenseData = driverLicenseData;
    }

    public InsuredAgeClassEnum getAgeClass() {
	return ageClass;
    }

    public void setAgeClass(InsuredAgeClassEnum ageClass) {
	this.ageClass = ageClass;
    }

    public InsuredExpirienceClassEnum getExpirienceClass() {
	return expirienceClass;
    }

    public void setExpirienceClass(InsuredExpirienceClassEnum expirienceClass) {
	this.expirienceClass = expirienceClass;
    }

    public boolean isHasAnyPrivilege() {
	return hasAnyPrivilege;
    }

    public void setHasAnyPrivilege(boolean hasAnyPrivilege) {
	this.hasAnyPrivilege = hasAnyPrivilege;
    }

    public boolean isPriveleger() {
	return priveleger;
    }

    public void setPriveleger(boolean priveleger) {
	this.priveleger = priveleger;
    }

    public PrivilegerCertificateData getPrivilegerCertificateData() {
	return privilegerCertificateData;
    }

    public void setPrivilegerCertificateData(PrivilegerCertificateData privilegerCertificateData) {
	this.privilegerCertificateData = privilegerCertificateData;
    }

    public boolean isHandicaped() {
	return handicaped;
    }

    public void setHandicaped(boolean handicaped) {
	this.handicaped = handicaped;
    }

    public HandicaptedCertificateData getHandicapedCertificateData() {
	return handicapedCertificateData;
    }

    public void setHandicapedCertificateData(HandicaptedCertificateData handicapedCertificateData) {
	this.handicapedCertificateData = handicapedCertificateData;
    }

    public boolean isGpwParticipant() {
	return gpwParticipant;
    }

    public void setGpwParticipant(boolean gpwParticipant) {
	this.gpwParticipant = gpwParticipant;
    }

    public GPWParticipantCertificateData getGpwParticipantCertificateData() {
	return gpwParticipantCertificateData;
    }

    public void setGpwParticipantCertificateData(GPWParticipantCertificateData gpwParticipantCertificateData) {
	this.gpwParticipantCertificateData = gpwParticipantCertificateData;
    }

    public boolean isPensioner() {
	return pensioner;
    }

    public void setPensioner(boolean pensioner) {
	this.pensioner = pensioner;
    }

    public PensionerCertificateData getPensionerCertificateData() {
	return pensionerCertificateData;
    }

    public void setPensionerCertificateData(PensionerCertificateData pensionerCertificateData) {
	this.pensionerCertificateData = pensionerCertificateData;
    }

    public ContactData getContactData() {
	return contactData;
    }

    public void setContactData(ContactData contactData) {
	this.contactData = contactData;
    }

    public boolean isFetched() {
	return fetched;
    }

    public void setFetched(boolean fetched) {
	this.fetched = fetched;
    }

}
