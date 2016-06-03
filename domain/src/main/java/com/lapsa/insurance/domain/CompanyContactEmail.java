package com.lapsa.insurance.domain;

public class CompanyContactEmail extends BaseEntity<Integer> {
    private String address;

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;
    }

}
