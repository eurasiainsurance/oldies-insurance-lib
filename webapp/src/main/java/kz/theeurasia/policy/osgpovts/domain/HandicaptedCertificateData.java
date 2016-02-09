package kz.theeurasia.policy.osgpovts.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kz.theeurasia.policy.general.domain.UploadedImage;

public class HandicaptedCertificateData {

    private String number;
    private Date validFrom;
    private Date validTill;
    private List<UploadedImage> scanFiles = new ArrayList<>();

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

    public List<UploadedImage> getScanFiles() {
	return scanFiles;
    }

    public void setScanFiles(List<UploadedImage> scanFiles) {
	this.scanFiles = scanFiles;
    }
}
