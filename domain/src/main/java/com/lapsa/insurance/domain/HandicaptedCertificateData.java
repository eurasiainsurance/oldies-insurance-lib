package com.lapsa.insurance.domain;

import java.util.Date;

import com.lapsa.insurance.validation.NotEmptyString;
import com.lapsa.insurance.validation.NotNullValue;

public class HandicaptedCertificateData extends BaseDomain {
    private static final long serialVersionUID = 3008779514582207946L;
    private static final int PRIME = 31;
    private static final int MULTIPLIER = PRIME;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

    @NotNullValue
    @NotEmptyString
    private String number;

    @NotNullValue
    private Date validFrom;

    @NotNullValue
    private Date validTill;

    private TwoSidedDocumentScan scan;

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

    public TwoSidedDocumentScan getScan() {
	return scan;
    }

    public void setScan(TwoSidedDocumentScan scan) {
	this.scan = scan;
    }
}
