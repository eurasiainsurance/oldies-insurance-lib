package com.lapsa.insurance.domain;

import java.util.Date;

import com.lapsa.insurance.validation.NotEmptyString;
import com.lapsa.insurance.validation.NotNullValue;
import com.lapsa.insurance.validation.ValidDateOfIssue;

public class GPWParticipantCertificateData extends BaseDomain implements ScanCopiedDocument {
    private static final long serialVersionUID = -2962825826022534176L;

    @NotNullValue
    @NotEmptyString
    private String number;

    @NotNullValue
    @ValidDateOfIssue
    private Date dateOfIssue;

    private MultipageDocumentScan scan = new MultipageDocumentScan();

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

    @Override
    public MultipageDocumentScan getScan() {
	return scan;
    }

    public void setScan(MultipageDocumentScan scan) {
	this.scan = scan;
    }
}
