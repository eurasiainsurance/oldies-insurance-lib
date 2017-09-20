package com.lapsa.insurance.domain;

import com.lapsa.international.country.Country;
import com.lapsa.international.country.validators.ValidCountry;
import com.lapsa.validation.NotNullValue;

public class OriginData extends BaseDomain {
    private static final long serialVersionUID = -2811566798584800985L;
    private static final int PRIME = 61;
    private static final int MULTIPLIER = PRIME;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

    @NotNullValue
    @ValidCountry
    private Country country;

    // GENERATED

    public Country getCountry() {
	return country;
    }

    public void setCountry(Country country) {
	this.country = country;
    }

}
