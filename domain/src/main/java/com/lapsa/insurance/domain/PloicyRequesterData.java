package com.lapsa.insurance.domain;

import com.lapsa.insurance.validation.NotEmptyString;
import com.lapsa.insurance.validation.NotNullValue;
import com.lapsa.internet.validators.ValidEmail;
import com.lapsa.phone.PhoneNumber;
import com.lapsa.phone.validators.ValidPhoneNumber;

public class PloicyRequesterData {

    @NotNullValue
    @NotEmptyString
    private String name;

    @NotNullValue
    @ValidPhoneNumber
    private PhoneNumber phone;

    @NotNullValue
    @ValidEmail
    private String email;

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
}
