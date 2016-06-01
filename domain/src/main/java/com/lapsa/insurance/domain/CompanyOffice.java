package com.lapsa.insurance.domain;

import java.util.List;

import com.lapsa.kz.country.KZCity;

public class CompanyOffice extends BaseEntity<Integer> {

    private KZCity city;
    private String address;
    private List<ContactPhone> phones;

    public KZCity getCity() {
	return city;
    }

    public void setCity(KZCity city) {
	this.city = city;
    }

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;
    }

    public List<ContactPhone> getPhones() {
	return phones;
    }

    public void setPhones(List<ContactPhone> phones) {
	this.phones = phones;
    }
}
