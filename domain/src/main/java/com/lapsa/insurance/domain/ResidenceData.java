package com.lapsa.insurance.domain;

import com.lapsa.kz.country.KZCity;
import com.lapsa.kz.country.validators.ValidKZCity;

import kz.theeurasia.policy.validator.NotEmptyString;
import kz.theeurasia.policy.validator.NotNullValue;

public class ResidenceData {

    private boolean resident;

    @NotNullValue
    @ValidKZCity
    private KZCity city;

    @NotNullValue
    @NotEmptyString
    private String address;

    // GENERATED

    public boolean isResident() {
	return resident;
    }

    public void setResident(boolean resident) {
	this.resident = resident;
    }

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

}
