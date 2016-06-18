package com.lapsa.insurance.domain;

import com.lapsa.country.Country;
import com.lapsa.country.validators.ValidCountry;
import com.lapsa.insurance.validation.NotNullValue;

public class OriginData extends BaseDomain {
    private static final long serialVersionUID = -2811566798584800985L;

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
