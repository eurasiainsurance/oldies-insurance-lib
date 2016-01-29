package kz.theeurasia.esbdproxy.domain.infos.osgpovts;

import java.util.Calendar;

public class PensionerInfo {

    private String certificateNumber;
    private Calendar certiticateDateOfIssue;

    public String getCertificateNumber() {
	return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
	this.certificateNumber = certificateNumber;
    }

    public Calendar getCertiticateDateOfIssue() {
	return certiticateDateOfIssue;
    }

    public void setCertiticateDateOfIssue(Calendar certiticateDateOfIssue) {
	this.certiticateDateOfIssue = certiticateDateOfIssue;
    }

}
