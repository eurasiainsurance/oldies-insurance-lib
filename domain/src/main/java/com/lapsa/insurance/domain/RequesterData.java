package com.lapsa.insurance.domain;

import javax.validation.constraints.AssertTrue;

import com.lapsa.insurance.validation.NotEmptyString;
import com.lapsa.insurance.validation.NotNullValue;
import com.lapsa.insurance.validation.ValidHumanName;
import com.lapsa.internet.validators.ValidEmail;
import com.lapsa.localization.LocalizationLanguage;
import com.lapsa.phone.PhoneFormatException;
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

    @NotNullValue
    @NotEmptyString
    @ValidHumanName
    private String name;

    @NotNullValue
    @NotEmptyString
    @ValidEmail
    private String email;

    @NotNullValue
    @ValidPhoneNumber(areaCodeLength = 3, numberLength = 7)
    private PhoneNumber phone;

    private boolean allowSpam;

    @AssertTrue(message = "{com.lapsa.insurance.domain.InsuranceRequest.allowProcessPersonalData.AssertTrue.message}")
    private boolean allowProcessPersonalData;

    @NotNullValue
    @ValidPhoneNumber(areaCodeLength = 3, numberLength = 7)
    public String getPhoneString() {
	if (phone == null)
	    return null;
	return phone.getFormatted();
    }

    private LocalizationLanguage preferLanguage;

    public void setPhoneString(String phoneString) {
	try {
	    phone = PhoneNumberFactoryProvider.provideDefault().parse(phoneString);
	} catch (PhoneFormatException ignored) {
	}
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
