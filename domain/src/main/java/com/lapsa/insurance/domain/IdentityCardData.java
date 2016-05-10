package com.lapsa.insurance.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lapsa.insurance.elements.IdentityCardType;

import kz.theeurasia.policy.validator.NotEmptyString;
import kz.theeurasia.policy.validator.NotNullValue;
import kz.theeurasia.policy.validator.ValidDateOfIssue;
import kz.theeurasia.policy.validator.ValidIdentityCardType;

public class IdentityCardData implements ScanCopiedDocument {

    @NotNullValue
    @ValidDateOfIssue
    private Date dateOfIssue;

    @NotNullValue
    @NotEmptyString
    private String issuingAuthority;

    @NotNullValue
    @NotEmptyString
    private String number;

    @NotNullValue
    @ValidIdentityCardType
    private IdentityCardType type;

    private List<UploadedImage> scanFiles = new ArrayList<>();

    // GENERATED

    public Date getDateOfIssue() {
	return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
	this.dateOfIssue = dateOfIssue;
    }

    public String getIssuingAuthority() {
	return issuingAuthority;
    }

    public void setIssuingAuthority(String issuingAuthority) {
	this.issuingAuthority = issuingAuthority;
    }

    public String getNumber() {
	return number;
    }

    public void setNumber(String number) {
	this.number = number;
    }

    public IdentityCardType getType() {
	return type;
    }

    public void setType(IdentityCardType type) {
	this.type = type;
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
