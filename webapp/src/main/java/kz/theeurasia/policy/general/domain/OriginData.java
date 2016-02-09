package kz.theeurasia.policy.general.domain;

import kz.theeurasia.esbdproxy.domain.dict.general.CountryDict;
import kz.theeurasia.policy.validator.NotNullValue;
import kz.theeurasia.policy.validator.ValidCountry;

public class OriginData {

    @NotNullValue
    @ValidCountry
    private CountryDict country = CountryDict.UNSPECIFIED;

    // GENERATED

    public CountryDict getCountry() {
	return country;
    }

    public void setCountry(CountryDict country) {
	this.country = country;
    }

}
