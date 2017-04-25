package com.lapsa.insurance.domain;

import com.lapsa.insurance.domain.policy.PolicyDriver;
import com.lapsa.insurance.elements.WhoIsInsurant;
import com.lapsa.kz.economic.KZEconomicSector;
import com.lapsa.kz.idnumber.validators.ValidIdNumber;
import com.lapsa.validation.NotNullValue;

public class InsurantData extends BaseEntity<Integer> {
    private static final long serialVersionUID = 5242824083075950955L;
    private static final int PRIME = 43;
    private static final int MULTIPLIER = PRIME;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

    @NotNullValue(message = "{com.lapsa.insurance.domain.InsurantData.IdNumber.NotNull.message}")
    @ValidIdNumber
    private String idNumber;

    private String taxPayerNumber;

    private PersonalData personalData = new PersonalData();
    private OriginData originData = new OriginData();
    private ResidenceData residenceData = new ResidenceData();
    private ContactData contactData = new ContactData();

    private IdentityCardData identityCardData = new IdentityCardData();

    private KZEconomicSector economicsSector = KZEconomicSector.HOUSEHOLDS;

    private PolicyDriver driverAsInsurant;

    @NotNullValue(message = "{com.lapsa.insurance.domain.InsurantData.WhoIsInsurant.NotNull.message}")
    private WhoIsInsurant whoIsInsurant = null;

    private boolean fetched = false;

    @Override
    public String toString() {
	return personalData.getDisplayName();
    }

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

    public PolicyDriver getDriverAsInsurant() {
	return driverAsInsurant;
    }

    public void setDriverAsInsurant(PolicyDriver driverAsInsurant) {
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
