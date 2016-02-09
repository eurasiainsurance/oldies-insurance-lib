package kz.theeurasia.policy.osgpovts.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kz.theeurasia.policy.general.domain.UploadedImage;
import kz.theeurasia.policy.validator.NotEmptyString;
import kz.theeurasia.policy.validator.NotNullValue;
import kz.theeurasia.policy.validator.ValidDateOfIssue;

public class PensionerCertificateData {

    @NotNullValue
    @NotEmptyString
    private String number;

    @NotNullValue
    @ValidDateOfIssue
    private Date dateOfIssue;

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

    public List<UploadedImage> getScanFiles() {
	return scanFiles;
    }

    public void setScanFiles(List<UploadedImage> scanFiles) {
	this.scanFiles = scanFiles;
    }

}
