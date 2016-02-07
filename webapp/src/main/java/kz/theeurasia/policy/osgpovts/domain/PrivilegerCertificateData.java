package kz.theeurasia.policy.osgpovts.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.primefaces.model.UploadedFile;

public class PrivilegerCertificateData {
    private String type;
    private String number;
    private Calendar dateOfIssue;
    private List<UploadedFile> scanFiles = new ArrayList<>();

    // GENERATED

    public String getType() {
	return type;
    }

    public void setType(String type) {
	this.type = type;
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

    public List<UploadedFile> getScanFiles() {
	return scanFiles;
    }

    public void setScanFiles(List<UploadedFile> scanFiles) {
	this.scanFiles = scanFiles;
    }

}
