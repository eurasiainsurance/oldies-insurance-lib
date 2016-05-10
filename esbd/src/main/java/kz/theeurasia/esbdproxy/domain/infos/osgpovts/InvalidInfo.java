package kz.theeurasia.esbdproxy.domain.infos.osgpovts;

import java.util.Calendar;

public class InvalidInfo {

    private String certificateNumber;
    private Calendar certificateValidFrom;
    private Calendar certificateValidTill;

    // GENERATED

    public String getCertificateNumber() {
	return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
	this.certificateNumber = certificateNumber;
    }

    public Calendar getCertificateValidFrom() {
	return certificateValidFrom;
    }

    public void setCertificateValidFrom(Calendar certificateValidFrom) {
	this.certificateValidFrom = certificateValidFrom;
    }

    public Calendar getCertificateValidTill() {
	return certificateValidTill;
    }

    public void setCertificateValidTill(Calendar certificateValidTill) {
	this.certificateValidTill = certificateValidTill;
    }

}
