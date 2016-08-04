package com.lapsa.insurance.domain;

public class CompanyContactEmail extends BaseEntity<Integer> {
    private static final long serialVersionUID = 4127152799405864110L;
    private static final int PRIME = 5;
    private static final int MULTIPLIER = PRIME;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

    private String address;

    // GENERATED

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;
    }

}
