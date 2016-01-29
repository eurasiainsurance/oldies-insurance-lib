package kz.theeurasia.esbdproxy.domain.entities;

import java.util.Calendar;

import kz.theeurasia.esbdproxy.domain.dict.IdentityCardTypeDict;

public class IdentityCardEntity {

    private Calendar dateOfIssue;
    private String issuingAuthority;
    private String number;
    private IdentityCardTypeDict identityCardType;

    public Calendar getDateOfIssue() {
	return dateOfIssue;
    }

    public void setDateOfIssue(Calendar dateOfIssue) {
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

    public IdentityCardTypeDict getIdentityCardType() {
	return identityCardType;
    }

    public void setIdentityCardType(IdentityCardTypeDict identityCardType) {
	this.identityCardType = identityCardType;
    }

}
