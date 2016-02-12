package kz.theeurasia.policy.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kz.theeurasia.esbdproxy.domain.dict.general.CountryRegionDict;
import kz.theeurasia.policy.validator.NotEmptyString;
import kz.theeurasia.policy.validator.NotNullValue;
import kz.theeurasia.policy.validator.ValidCountryRegion;
import kz.theeurasia.policy.validator.ValidDateOfIssue;
import kz.theeurasia.policy.validator.ValidVehicleRegistrationNumber;

public class VehicleCertificateData {

    @NotNullValue
    @NotEmptyString
    @ValidVehicleRegistrationNumber
    private String vehicleRegistrationNumber;

    @NotNullValue
    @NotEmptyString
    private String number;

    @NotNullValue
    @ValidDateOfIssue
    private Date dateOfIssue;

    @NotNullValue
    @ValidCountryRegion
    private CountryRegionDict region = CountryRegionDict.UNSPECIFIED;

    private boolean majorCity;

    private List<UploadedImage> scanFiles = new ArrayList<>();

    // GENERATED

    public String getNumber() {
	return number;
    }

    public void setNumber(String number) {
	this.number = number;
    }

    public Date getDateOfIssue() {
	return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
	this.dateOfIssue = dateOfIssue;
    }

    public CountryRegionDict getRegion() {
	return region;
    }

    public void setRegion(CountryRegionDict region) {
	this.region = region;
    }

    public boolean isMajorCity() {
	return majorCity;
    }

    public void setMajorCity(boolean majorCity) {
	this.majorCity = majorCity;
    }

    public String getVehicleRegistrationNumber() {
	return vehicleRegistrationNumber;
    }

    public void setVehicleRegistrationNumber(String vehicleRegistrationNumber) {
	this.vehicleRegistrationNumber = vehicleRegistrationNumber;
    }

    public List<UploadedImage> getScanFiles() {
	return scanFiles;
    }

    public void setScanFiles(List<UploadedImage> scanFiles) {
	this.scanFiles = scanFiles;
    }

}
