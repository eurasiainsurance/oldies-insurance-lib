package com.lapsa.insurance.domain;

import tech.lapsa.java.commons.function.MyOptionals;
import tech.lapsa.javax.validation.NotNullValue;
import tech.lapsa.kz.taxpayer.TaxpayerNumber;
import tech.lapsa.kz.taxpayer.validators.ValidTaxpayerNumber;

public abstract class Driver extends BaseEntity {
    private static final long serialVersionUID = -9161699848130198940L;

    @NotNullValue
    @ValidTaxpayerNumber
    protected TaxpayerNumber idNumber;

    protected String taxPayerNumber;

    protected PersonalData personalData = new PersonalData();
    protected OriginData originData = new OriginData();
    protected ResidenceData residenceData = new ResidenceData();
    protected IdentityCardData identityCardData = new IdentityCardData();
    protected DriverLicenseData driverLicenseData = new DriverLicenseData();
    protected ContactData contactData = new ContactData();

    @Override
    public void unlazy() {
	super.unlazy();
	MyOptionals.of(getDriverLicenseData()).ifPresent(Domain::unlazy);
    }

    // GENERATED

    public TaxpayerNumber getIdNumber() {
	return idNumber;
    }

    public void setIdNumber(TaxpayerNumber idNumber) {
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
