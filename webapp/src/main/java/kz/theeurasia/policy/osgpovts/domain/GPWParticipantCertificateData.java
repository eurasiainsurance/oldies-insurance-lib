package kz.theeurasia.policy.osgpovts.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.primefaces.model.UploadedFile;

public class GPWParticipantCertificateData {

    private String number;
    private Date dateOfIssue;
    private List<UploadedFile> scanFiles = new ArrayList<>();

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

    public List<UploadedFile> getScanFiles() {
	return scanFiles;
    }

    public void setScanFiles(List<UploadedFile> scanFiles) {
	this.scanFiles = scanFiles;
    }
}
