package kz.theeurasia.policy.general.domain;

import java.util.Date;

import kz.theeurasia.esbdproxy.domain.dict.general.IdentityCardTypeDict;

public class IdentityCardData {
    private Date dateOfIssue;

    private String issuingAuthority;

    private String number;

    private IdentityCardTypeDict identityCardType = IdentityCardTypeDict.UNSPECIFIED;

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

    public IdentityCardTypeDict getIdentityCardType() {
	return identityCardType;
    }

    public void setIdentityCardType(IdentityCardTypeDict identityCardType) {
	this.identityCardType = identityCardType;
    }

}
