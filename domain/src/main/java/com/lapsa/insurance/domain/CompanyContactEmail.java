package com.lapsa.insurance.domain;

public class CompanyContactEmail extends BaseEntity<Integer> {
    private static final long serialVersionUID = 4127152799405864110L;

    private String address;

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;
    }

}
