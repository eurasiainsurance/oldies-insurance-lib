package com.lapsa.insurance.domain;

import com.lapsa.insurance.validation.NotEmptyString;
import com.lapsa.insurance.validation.NotNullValue;
import com.lapsa.insurance.validation.ValidHumanName;
import com.lapsa.internet.validators.ValidEmail;
import com.lapsa.phone.PhoneFormatException;
import com.lapsa.phone.PhoneNumber;
import com.lapsa.phone.PhoneNumberFactoryProvider;
import com.lapsa.phone.validators.ValidPhoneNumber;

public class PloicyRequesterData {

    @NotNullValue
    @NotEmptyString
    @ValidHumanName
    private String name;

    @NotNullValue
    @NotEmptyString
    @ValidEmail
    private String email;

    @NotNullValue
    @ValidPhoneNumber
    private PhoneNumber phone;

    @NotNullValue
    @ValidPhoneNumber
    public String getPhoneString() {
	if (phone == null)
	    return null;
	return phone.getFormatted();
    }

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
}
