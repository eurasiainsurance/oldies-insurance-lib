package kz.theeurasia.policy.osgpovts.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import kz.theeurasia.esbdproxy.domain.dict.general.CountryRegionDict;
import kz.theeurasia.policy.general.domain.UploadedImage;

public class VehicleCertificateData {

    private String vehicleRegisterNumber;
    private String number;
    private Calendar dateOfIssue;
    private CountryRegionDict region = CountryRegionDict.UNSPECIFIED;
    private boolean majorCity;
    private List<UploadedImage> scanFiles = new ArrayList<>();

    // GENERATED

    public String getVehicleRegisterNumber() {
	return vehicleRegisterNumber;
    }

    public void setVehicleRegisterNumber(String vehicleRegisterNumber) {
	this.vehicleRegisterNumber = vehicleRegisterNumber;
    }

    public String getNumber() {
	return number;
    }

    public void setNumber(String number) {
	this.number = number;
    }

    public Calendar getDateOfIssue() {
	return dateOfIssue;
    }

    public void setDateOfIssue(Calendar dateOfIssue) {
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

    public List<UploadedImage> getScanFiles() {
	return scanFiles;
    }

    public void setScanFiles(List<UploadedImage> scanFiles) {
	this.scanFiles = scanFiles;
    }
}
