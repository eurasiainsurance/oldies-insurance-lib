package com.lapsa.insurance.domain;

import com.lapsa.insurance.elements.InsuranceClassType;
import com.lapsa.insurance.elements.InsuredAgeClass;
import com.lapsa.insurance.elements.InsuredExpirienceClass;
import com.lapsa.insurance.validation.NotNullValue;
import com.lapsa.insurance.validation.ValidInsuranceAgeClass;
import com.lapsa.insurance.validation.ValidInsuranceExpirienceClass;
import com.lapsa.kz.idnumber.validators.ValidIdNumber;

public class InsuredDriverData extends BaseEntity<Integer> {
    private static final long serialVersionUID = 5209394299289430299L;

    private InsuranceClassType insuranceClassType;

    @NotNullValue(message = "{com.lapsa.insurance.domain.InsuredDriverData.IdNumber.NotNull.message}")
    @ValidIdNumber
    private String idNumber;

    @NotNullValue
    @ValidInsuranceAgeClass
    private InsuredAgeClass ageClass;

    @NotNullValue
    @ValidInsuranceExpirienceClass
    private InsuredExpirienceClass expirienceClass;

    private String taxPayerNumber;

    private PersonalData personalData = new PersonalData();
    private OriginData originData = new OriginData();
    private ResidenceData residenceData = new ResidenceData();
    private IdentityCardData identityCardData = new IdentityCardData();
    private DriverLicenseData driverLicenseData = new DriverLicenseData();
    private ContactData contactData = new ContactData();

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

    public String getDisplayName() {
	return personalData.getDisplayName();
    }

    @Override
    public String toString() {
	return personalData.getDisplayName();
    }

    // GENERATED

    public InsuranceClassType getInsuranceClassType() {
	return insuranceClassType;
    }

    public void setInsuranceClassType(InsuranceClassType insuranceClassType) {
	this.insuranceClassType = insuranceClassType;
    }

    public String getIdNumber() {
	return idNumber;
    }

    public void setIdNumber(String idNumber) {
	this.idNumber = idNumber;
    }

    public InsuredAgeClass getAgeClass() {
	return ageClass;
    }

    public void setAgeClass(InsuredAgeClass ageClass) {
	this.ageClass = ageClass;
    }

    public InsuredExpirienceClass getExpirienceClass() {
	return expirienceClass;
    }

    public void setExpirienceClass(InsuredExpirienceClass expirienceClass) {
	this.expirienceClass = expirienceClass;
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
}
