package com.lapsa.insurance.domain;

import java.time.LocalDate;

import com.lapsa.insurance.elements.IdentityCardType;
import com.lapsa.insurance.validation.NotEmptyString;
import com.lapsa.insurance.validation.NotNullValue;
import com.lapsa.insurance.validation.ValidDateOfIssue;
import com.lapsa.insurance.validation.ValidIdentityCardType;

public class IdentityCardData extends SidedScannedDocument {
    private static final long serialVersionUID = 6150409229272494445L;
    private static final int PRIME = 37;
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
    @ValidDateOfIssue
    private LocalDate dateOfIssue;

    @NotNullValue
    @NotEmptyString
    private String issuingAuthority;

    @NotNullValue
    @NotEmptyString
    private String number;

    @NotNullValue
    @ValidIdentityCardType
    private IdentityCardType type;

    // GENERATED

    public LocalDate getDateOfIssue() {
	return dateOfIssue;
    }

    public void setDateOfIssue(LocalDate dateOfIssue) {
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
}
