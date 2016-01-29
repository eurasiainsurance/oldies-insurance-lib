package kz.theeurasia.esbdproxy.domain.infos;

import java.util.Calendar;

import kz.theeurasia.esbdproxy.domain.dict.CountryRegionDict;

public class VehicleCertificateInfo {
    // TF_NUMBER s:string Гос. номер ТС
    private String registrationNumber;

    // TF_REGISTRATION_CERTIFICATE s:string Номер тех. паспорта
    private String certificateNumber;

    // GIVE_DATE s:string Дата выдачи тех. паспорта
    private Calendar dateOfIssue;

    // REGION_ID s:int Идентификатор региона регистрации ТС (обязательно)
    private CountryRegionDict registrationRegion;

    // BIG_CITY_BOOL s:int Признак города областного значения (обязательно)
    private boolean majorCity;

    public String getRegistrationNumber() {
	return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
	this.registrationNumber = registrationNumber;
    }

    public String getCertificateNumber() {
	return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
	this.certificateNumber = certificateNumber;
    }

    public Calendar getDateOfIssue() {
	return dateOfIssue;
    }

    public void setDateOfIssue(Calendar dateOfIssue) {
	this.dateOfIssue = dateOfIssue;
    }

    public CountryRegionDict getRegistrationRegion() {
	return registrationRegion;
    }

    public void setRegistrationRegion(CountryRegionDict registrationRegion) {
	this.registrationRegion = registrationRegion;
    }

    public boolean isMajorCity() {
	return majorCity;
    }

    public void setMajorCity(boolean majorCity) {
	this.majorCity = majorCity;
    }

}
