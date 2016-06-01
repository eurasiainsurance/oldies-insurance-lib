package com.lapsa.insurance.domain;

import java.util.Date;

import com.lapsa.insurance.validation.NotEmptyString;
import com.lapsa.insurance.validation.NotNullValue;
import com.lapsa.insurance.validation.ValidDateOfIssue;

public class PrivilegerCertificateData extends BaseDomain {

    @NotNullValue
    @NotEmptyString
    private String type;

    @NotNullValue
    @NotEmptyString
    private String number;

    @NotNullValue
    @ValidDateOfIssue
    private Date dateOfIssue;

    private MultipageDocumentScan scan;

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

    public Date getDateOfIssue() {
	return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
	this.dateOfIssue = dateOfIssue;
    }

    public MultipageDocumentScan getScan() {
	return scan;
    }

    public void setScan(MultipageDocumentScan scan) {
	this.scan = scan;
    }
}
