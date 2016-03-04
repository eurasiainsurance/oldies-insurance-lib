package kz.theeurasia.policy.domain;

import kz.theeurasia.policy.validator.NotNullValue;
import kz.theeurasia.policy.validator.ValidEmail;
import kz.theeurasia.policy.validator.ValidPhoneNumber;
import kz.theeurasia.policy.validator.ValidURL;

public class ContactData {

    @NotNullValue
    @ValidPhoneNumber
    private String phone;

    @NotNullValue
    @ValidEmail
    private String email;

    @ValidURL
    private String siteUrl;

    // GENERATED

    public String getPhone() {
	return phone;
    }

    public void setPhone(String phone) {
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
