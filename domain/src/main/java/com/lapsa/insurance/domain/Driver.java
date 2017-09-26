package com.lapsa.insurance.domain;

import com.lapsa.kz.idnumber.validators.ValidIdNumber;

public abstract class Driver extends BaseEntity<Integer> {
    private static final long serialVersionUID = -9161699848130198940L;

    @ValidIdNumber
    protected String idNumber;

    protected String taxPayerNumber;

    protected PersonalData personalData = new PersonalData();
    protected OriginData originData = new OriginData();
    protected ResidenceData residenceData = new ResidenceData();
    protected IdentityCardData identityCardData = new IdentityCardData();
    protected DriverLicenseData driverLicenseData = new DriverLicenseData();
    protected ContactData contactData = new ContactData();

    // GENERATED

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

    public ContactData getContactData() {
	return contactData;
    }

    public void setContactData(ContactData contactData) {
	this.contactData = contactData;
    }
}
