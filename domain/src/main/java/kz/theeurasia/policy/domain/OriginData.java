package kz.theeurasia.policy.domain;

import com.lapsa.country.Country;

import kz.theeurasia.policy.validator.NotNullValue;
import kz.theeurasia.policy.validator.ValidCountry;

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
