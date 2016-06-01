package com.lapsa.insurance.domain;

import java.util.Date;

import com.lapsa.insurance.validation.NotEmptyString;
import com.lapsa.insurance.validation.NotNullValue;

public class HandicaptedCertificateData extends BaseDomain implements ScanCopiedDocument {

    @NotNullValue
    @NotEmptyString
    private String number;

    @NotNullValue
    private Date validFrom;

    @NotNullValue
    private Date validTill;

    private MultipageDocumentScan scan;

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

    @Override
    public MultipageDocumentScan getScan() {
	return scan;
    }

    public void setScan(MultipageDocumentScan scan) {
	this.scan = scan;
    }
}
