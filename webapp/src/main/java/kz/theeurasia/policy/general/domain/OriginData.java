package kz.theeurasia.policy.general.domain;

import kz.theeurasia.esbdproxy.domain.dict.general.CountryDict;
import kz.theeurasia.esbdproxy.domain.entities.general.CityEntity;

public class OriginData {
    private boolean resident;

    private CountryDict country = CountryDict.UNSPECIFIED;

    private CityEntity city;

    // GENERATED

    public boolean isResident() {
	return resident;
    }

    public void setResident(boolean resident) {
	this.resident = resident;
    }

    public CountryDict getCountry() {
	return country;
    }

    public void setCountry(CountryDict country) {
	this.country = country;
    }

    public CityEntity getCity() {
	return city;
    }

    public void setCity(CityEntity city) {
	this.city = city;
    }

}
