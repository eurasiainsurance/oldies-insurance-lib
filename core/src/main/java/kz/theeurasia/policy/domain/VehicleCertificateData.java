package kz.theeurasia.policy.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lapsa.kz.country.KZArea;

import kz.theeurasia.policy.validator.NotEmptyString;
import kz.theeurasia.policy.validator.NotNullValue;
import kz.theeurasia.policy.validator.ValidKZArea;
import kz.theeurasia.policy.validator.ValidDateOfIssue;
import kz.theeurasia.policy.validator.ValidVehicleRegistrationNumber;

public class VehicleCertificateData implements ScanCopiedDocument {

    @NotNullValue
    @NotEmptyString
    @ValidVehicleRegistrationNumber
    private String registrationNumber;

    @NotNullValue
    @NotEmptyString
    private String number;

    @NotNullValue
    @ValidDateOfIssue
    private Date dateOfIssue;

    @NotNullValue
    @ValidKZArea
    private KZArea region;

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

    public KZArea getRegion() {
	return region;
    }

    public void setRegion(KZArea region) {
	this.region = region;
    }

    public boolean isMajorCity() {
	return majorCity;
    }

    public void setMajorCity(boolean majorCity) {
	this.majorCity = majorCity;
    }

    public String getRegistrationNumber() {
	return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
	this.registrationNumber = registrationNumber;
    }

    @Override
    public List<UploadedImage> getScanFiles() {
	return scanFiles;
    }

    @Override
    public void setScanFiles(List<UploadedImage> scanFiles) {
	this.scanFiles = scanFiles;
    }

    @Override
    public void addScanFile(UploadedImage im) {
	scanFiles.add(im);
    }

    @Override
    public void removeScanFile(UploadedImage im) {
	scanFiles.remove(im);
    }
}
