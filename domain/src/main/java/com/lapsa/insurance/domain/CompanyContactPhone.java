package com.lapsa.insurance.domain;

import com.lapsa.phone.PhoneNumber;
import com.lapsa.phone.PhoneType;

public class CompanyContactPhone extends BaseDomain {

    private PhoneNumber phone;
    private PhoneType phoneType;

    public PhoneNumber getPhone() {
	return phone;
    }

    public void setPhone(PhoneNumber phone) {
	this.phone = phone;
    }

    public PhoneType getPhoneType() {
	return phoneType;
    }

    public void setPhoneType(PhoneType phoneType) {
	this.phoneType = phoneType;
    }
}
