package kz.theeurasia.policy.general.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kz.theeurasia.esbdproxy.domain.dict.general.IdentityCardTypeDict;

public class IdentityCardData {
    private Date dateOfIssue;

    private String issuingAuthority;

    private String number;

    private IdentityCardTypeDict type = IdentityCardTypeDict.UNSPECIFIED;

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

    public IdentityCardTypeDict getType() {
	return type;
    }

    public void setType(IdentityCardTypeDict type) {
	this.type = type;
    }

    public List<UploadedImage> getScanFiles() {
	return scanFiles;
    }

    public void setScanFiles(List<UploadedImage> scanFiles) {
	this.scanFiles = scanFiles;
    }
}
