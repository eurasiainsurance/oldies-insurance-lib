package com.lapsa.insurance.domain;

import java.util.Date;

import com.lapsa.insurance.validation.NotEmptyString;
import com.lapsa.insurance.validation.NotNullValue;
import com.lapsa.insurance.validation.ValidDateOfIssue;
import com.lapsa.insurance.validation.ValidVehicleRegistrationNumber;

public class VehicleCertificateData extends BaseDomain<Integer> implements ScanCopiedDocument {

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

    private TwoSidedDocumentScan scan = new TwoSidedDocumentScan();

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

    public String getRegistrationNumber() {
	return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
	this.registrationNumber = registrationNumber;
    }

    @Override
    public TwoSidedDocumentScan getScan() {
	return scan;
    }

    public void setScan(TwoSidedDocumentScan scan) {
	this.scan = scan;
    }
}
