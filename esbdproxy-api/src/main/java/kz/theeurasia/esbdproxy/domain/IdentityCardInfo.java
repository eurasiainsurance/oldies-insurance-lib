package kz.theeurasia.esbdproxy.domain;

import java.util.Calendar;

public class IdentityCardInfo {

    private Calendar dateOfIssue;
    private String issuingAuthority;
    private String number;
    private IdentityCardTypeInfo identityCardTypeInfo;

    public IdentityCardInfo() {
    }

    public IdentityCardInfo(Calendar dateOfIssue, String issuingAuthority, String number, IdentityCardTypeInfo identityCardTypeInfo) {
	this.dateOfIssue = dateOfIssue;
	this.issuingAuthority = issuingAuthority;
	this.number = number;
	this.identityCardTypeInfo = identityCardTypeInfo;
    }

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

    public IdentityCardTypeInfo getIdentityCardTypeInfo() {
	return identityCardTypeInfo;
    }

    public void setIdentityCardTypeInfo(IdentityCardTypeInfo identityCardTypeInfo) {
	this.identityCardTypeInfo = identityCardTypeInfo;
    }

}
