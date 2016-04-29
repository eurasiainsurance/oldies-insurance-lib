package kz.theeurasia.policy.domain;

import com.lapsa.country.Country;
import com.lapsa.country.validators.ValidCountry;

import kz.theeurasia.policy.validator.NotNullValue;

public class OriginData {

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
