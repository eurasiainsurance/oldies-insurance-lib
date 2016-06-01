package com.lapsa.insurance.domain;

import java.util.Date;

import com.lapsa.insurance.elements.IdentityCardType;
import com.lapsa.insurance.validation.NotEmptyString;
import com.lapsa.insurance.validation.NotNullValue;
import com.lapsa.insurance.validation.ValidDateOfIssue;
import com.lapsa.insurance.validation.ValidIdentityCardType;

public class IdentityCardData extends BaseEntity<Integer> implements ScanCopiedDocument {

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

    private TwoSidedDocumentScan scan = new TwoSidedDocumentScan();

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
    public TwoSidedDocumentScan getScan() {
	return scan;
    }

    public void setScan(TwoSidedDocumentScan scan) {
	this.scan = scan;
    }
}
