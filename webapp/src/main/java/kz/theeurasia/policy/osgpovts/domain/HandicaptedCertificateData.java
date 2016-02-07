package kz.theeurasia.policy.osgpovts.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.primefaces.model.UploadedFile;

public class HandicaptedCertificateData {

    private String number;
    private Date validFrom;
    private Date validTill;
    private List<UploadedFile> scanFiles = new ArrayList<>();

    // GENERATED

    public String getNumber() {
	return number;
    }

    public void setNumber(String number) {
	this.number = number;
    }

    public Date getValidFrom() {
	return validFrom;
    }

    public void setValidFrom(Date validFrom) {
	this.validFrom = validFrom;
    }

    public Date getValidTill() {
	return validTill;
    }

    public void setValidTill(Date validTill) {
	this.validTill = validTill;
    }

    public List<UploadedFile> getScanFiles() {
	return scanFiles;
    }

    public void setScanFiles(List<UploadedFile> scanFiles) {
	this.scanFiles = scanFiles;
    }
}
