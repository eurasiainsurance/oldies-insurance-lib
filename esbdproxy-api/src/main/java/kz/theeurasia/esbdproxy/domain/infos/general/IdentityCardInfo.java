package kz.theeurasia.esbdproxy.domain.infos.general;

import java.util.Calendar;

import kz.theeurasia.esbdproxy.domain.dict.general.IdentityCardTypeDict;

public class IdentityCardInfo {
    // DOCUMENT_GIVED_DATE s:string Дата выдачи документа
    private Calendar dateOfIssue;

    // DOCUMENT_GIVED_BY s:string Документ выдан
    private String issuingAuthority;

    // DOCUMENT_NUMBER s:string Номер документа
    private String number;

    // DOCUMENT_TYPE_ID s:int Тип документа (справочник DOCUMENTS_TYPES)
    private IdentityCardTypeDict identityCardType = IdentityCardTypeDict.UNSPECIFIED;

    // GENERATED

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
