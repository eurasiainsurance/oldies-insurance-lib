package com.lapsa.insurance.domain;

import javax.validation.constraints.AssertTrue;

import com.lapsa.insurance.validation.NotNullValue;
import com.lapsa.insurance.validation.ValidHumanName;
import com.lapsa.internet.validators.ValidEmail;
import com.lapsa.kz.idnumber.validators.ValidIdNumber;
import com.lapsa.localization.LocalizationLanguage;
import com.lapsa.phone.PhoneNumber;
import com.lapsa.phone.PhoneNumberFactoryProvider;
import com.lapsa.phone.validators.ValidPhoneNumber;

public class RequesterData extends BaseDomain {
    private static final long serialVersionUID = 2536050924805456436L;
    private static final int PRIME = 73;
    private static final int MULTIPLIER = PRIME;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

    @ValidHumanName
    private String name;

    @ValidEmail
    private String email;

    @ValidIdNumber
    private String idNumber;

    @NotNullValue
    @ValidPhoneNumber
    private PhoneNumber phone;

    private boolean allowSpam;

    @AssertTrue(message = "{com.lapsa.insurance.domain.InsuranceRequest.allowProcessPersonalData.AssertTrue.message}")
    private boolean allowProcessPersonalData;

    private LocalizationLanguage preferLanguage;

    @NotNullValue
    @ValidPhoneNumber
    public String getPhoneString() {
	if (phone == null)
	    return null;
	return phone.getRaw();
    }

    public void setPhoneString(String phoneString) {
	phone = null;
	if (phoneString != null && !phoneString.isEmpty())
	    phone = PhoneNumberFactoryProvider.provideDefault().parse(phoneString);
    }

    // GENERATED

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public PhoneNumber getPhone() {
	return phone;
    }

    public void setPhone(PhoneNumber phone) {
	this.phone = phone;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getIdNumber() {
	return idNumber;
    }

    public void setIdNumber(String idNumber) {
	this.idNumber = idNumber;
    }

    public LocalizationLanguage getPreferLanguage() {
	return preferLanguage;
    }

    public void setPreferLanguage(LocalizationLanguage preferLanguage) {
	this.preferLanguage = preferLanguage;
    }

    public boolean isAllowSpam() {
	return allowSpam;
    }

    public void setAllowSpam(boolean allowSpam) {
	this.allowSpam = allowSpam;
    }

    public boolean isAllowProcessPersonalData() {
	return allowProcessPersonalData;
    }

    public void setAllowProcessPersonalData(boolean allowProcessPersonalData) {
	this.allowProcessPersonalData = allowProcessPersonalData;
    }
}
