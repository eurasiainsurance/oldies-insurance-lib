package kz.theeurasia.services.domain.osgpovts;

import java.util.Calendar;

public class DocumentInfo {

    private String type;
    private Calendar dateOfIssue;
    private String issuingAuthority;
    private String number;
    private int typeId;

    public DocumentInfo() {
    }

    public DocumentInfo(String type, Calendar dateOfIssue, String issuingAuthority, String number) {
	super();
	this.type = type;
	this.dateOfIssue = dateOfIssue;
	this.issuingAuthority = issuingAuthority;
	this.number = number;
    }

    public String getType() {
	return type;
    }

    public void setType(String type) {
	this.type = type;
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

    public int getTypeId() {
	return typeId;
    }

    public void setTypeId(int typeId) {
	this.typeId = typeId;
    }

}
