package kz.theeurasia.policy.general.domain;

import kz.theeurasia.esbdproxy.domain.dict.general.CountryDict;

public class OriginData {

    private CountryDict country = CountryDict.UNSPECIFIED;

    // GENERATED

    public CountryDict getCountry() {
	return country;
    }

    public void setCountry(CountryDict country) {
	this.country = country;
    }

}
