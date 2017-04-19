package com.lapsa.insurance.domain;

import java.time.LocalDate;

import com.lapsa.validation.NotEmptyString;
import com.lapsa.validation.NotNullValue;

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
    private LocalDate validFrom;

    @NotNullValue
    private LocalDate validTill;

    private TwoSidedDocumentScan scan = new TwoSidedDocumentScan();

    // GENERATED

    public String getNumber() {
	return number;
    }

    public void setNumber(String number) {
	this.number = number;
    }

    public LocalDate getValidFrom() {
	return validFrom;
    }

    public void setValidFrom(LocalDate validFrom) {
	this.validFrom = validFrom;
    }

    public LocalDate getValidTill() {
	return validTill;
    }

    public void setValidTill(LocalDate validTill) {
	this.validTill = validTill;
    }

    public TwoSidedDocumentScan getScan() {
	return scan;
    }

    public void setScan(TwoSidedDocumentScan scan) {
	this.scan = scan;
    }
}
