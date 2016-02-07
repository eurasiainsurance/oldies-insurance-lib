package kz.theeurasia.policy.osgpovts.domain;

import java.util.Calendar;

import kz.theeurasia.esbdproxy.domain.dict.general.CountryRegionDict;

public class VehicleCertificateData {
    private String registrationNumber;

    private String certificateNumber;

    private Calendar dateOfIssue;

    private CountryRegionDict registrationRegion = CountryRegionDict.UNSPECIFIED;

    private boolean majorCity = false;

    // GENERATED

    public String getRegistrationNumber() {
	return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
	this.registrationNumber = registrationNumber;
    }

    public String getCertificateNumber() {
	return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
	this.certificateNumber = certificateNumber;
    }

    public Calendar getDateOfIssue() {
	return dateOfIssue;
    }

    public void setDateOfIssue(Calendar dateOfIssue) {
	this.dateOfIssue = dateOfIssue;
    }

    public CountryRegionDict getRegistrationRegion() {
	return registrationRegion;
    }

    public void setRegistrationRegion(CountryRegionDict registrationRegion) {
	this.registrationRegion = registrationRegion;
    }

    public boolean isMajorCity() {
	return majorCity;
    }

    public void setMajorCity(boolean majorCity) {
	this.majorCity = majorCity;
    }

}
