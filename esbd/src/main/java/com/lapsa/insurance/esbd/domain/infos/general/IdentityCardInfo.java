package com.lapsa.insurance.esbd.domain.infos.general;

import java.util.Calendar;

import com.lapsa.insurance.elements.IdentityCardType;

public class IdentityCardInfo {
    // DOCUMENT_GIVED_DATE s:string Дата выдачи документа
    private Calendar dateOfIssue;

    // DOCUMENT_GIVED_BY s:string Документ выдан
    private String issuingAuthority;

    // DOCUMENT_NUMBER s:string Номер документа
    private String number;

    // DOCUMENT_TYPE_ID s:int Тип документа (справочник DOCUMENTS_TYPES)
    private IdentityCardType identityCardType;

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

    public IdentityCardType getIdentityCardType() {
	return identityCardType;
    }

    public void setIdentityCardType(IdentityCardType identityCardType) {
	this.identityCardType = identityCardType;
    }

}
