package com.lapsa.insurance.domain;

import com.lapsa.internet.validators.ValidEmail;
import com.lapsa.internet.validators.ValidURL;
import com.lapsa.phone.PhoneNumber;
import com.lapsa.phone.validators.ValidPhoneNumber;

import kz.theeurasia.policy.validator.NotNullValue;

public class ContactData {

    @NotNullValue
    @ValidPhoneNumber
    private PhoneNumber phone;

    @NotNullValue
    @ValidEmail
    private String email;

    @ValidURL
    private String siteUrl;

    // GENERATED

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

    public String getSiteUrl() {
	return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
	this.siteUrl = siteUrl;
    }

}
