package kz.theeurasia.esbdproxy.domain.infos.osgpovts;

import java.util.Calendar;

public class CertificateInfo {
    private String number;
    private Calendar dateOfIssue;

    public CertificateInfo() {
    }

    public CertificateInfo(String number, Calendar dateOfIssue) {
	this.number = number;
	this.dateOfIssue = dateOfIssue;
    }

    public String getNumber() {
	return number;
    }

    public void setNumber(String number) {
	this.number = number;
    }

    public Calendar getDateOfIssue() {
	return dateOfIssue;
    }

    public void setDateOfIssue(Calendar dateOfIssue) {
	this.dateOfIssue = dateOfIssue;
    }

}
