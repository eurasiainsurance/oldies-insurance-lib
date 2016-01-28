package kz.theeurasia.esbd.domain;

import java.util.Calendar;

public class DocumentInfo {

    private Calendar dateOfIssue;
    private String issuingAuthority;
    private String number;
    private DocumentTypeInfo documentType;

    public DocumentInfo() {
    }

    public DocumentInfo(Calendar dateOfIssue, String issuingAuthority, String number, DocumentTypeInfo documentType) {
	this.dateOfIssue = dateOfIssue;
	this.issuingAuthority = issuingAuthority;
	this.number = number;
	this.documentType = documentType;
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

    public DocumentTypeInfo getDocumentType() {
	return documentType;
    }

    public void setDocumentType(DocumentTypeInfo documentType) {
	this.documentType = documentType;
    }

}
