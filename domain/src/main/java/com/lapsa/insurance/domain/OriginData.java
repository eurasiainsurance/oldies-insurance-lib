package com.lapsa.insurance.domain;

import com.lapsa.country.Country;
import com.lapsa.country.validators.ValidCountry;
import com.lapsa.insurance.validation.NotNullValue;

public class OriginData extends BaseDomain {
    private static final long serialVersionUID = -2811566798584800985L;
    private static final int PRIME = 61;
    private static final int MULTIPLIER = 61;

    @NotNullValue
    @ValidCountry
    private Country country;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

    // GENERATED

    public Country getCountry() {
	return country;
    }

    public void setCountry(Country country) {
	this.country = country;
    }

}
