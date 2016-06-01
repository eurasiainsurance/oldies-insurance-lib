package com.lapsa.insurance.domain;

import com.lapsa.phone.PhoneNumber;

public class CompanyContactPhone extends BaseDomain {

    private PhoneNumber phone;

    public PhoneNumber getPhone() {
	return phone;
    }

    public void setPhone(PhoneNumber phone) {
	this.phone = phone;
    }

}
