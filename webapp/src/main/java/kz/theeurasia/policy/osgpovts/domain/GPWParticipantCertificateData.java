package kz.theeurasia.policy.osgpovts.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kz.theeurasia.policy.general.domain.UploadedImage;

public class GPWParticipantCertificateData {

    private String number;
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
