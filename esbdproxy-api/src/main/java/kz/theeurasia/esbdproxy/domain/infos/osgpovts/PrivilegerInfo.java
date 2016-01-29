package kz.theeurasia.esbdproxy.domain.infos.osgpovts;

import java.util.Calendar;

public class PrivilegerInfo {
    private String type;
    private String certificateNumber;
    private Calendar certificateDateOfIssue;

    public String getType() {
	return type;
    }

    public void setType(String type) {
	this.type = type;
    }

    public String getCertificateNumber() {
	return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
	this.certificateNumber = certificateNumber;
    }

    public Calendar getCertificateDateOfIssue() {
	return certificateDateOfIssue;
    }

    public void setCertificateDateOfIssue(Calendar certificateDateOfIssue) {
	this.certificateDateOfIssue = certificateDateOfIssue;
    }

}
