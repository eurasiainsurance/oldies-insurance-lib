package kz.theeurasia.policy.domain;

import kz.theeurasia.esbdproxy.domain.dict.general.KZCityDict;
import kz.theeurasia.policy.validator.NotEmptyString;
import kz.theeurasia.policy.validator.NotNullValue;
import kz.theeurasia.policy.validator.ValidKZCity;

public class ResidenceData {

    private boolean resident;

    @NotNullValue
    @ValidKZCity
    private KZCityDict city = KZCityDict.UNSPECIFIED;

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

    public KZCityDict getCity() {
	return city;
    }

    public void setCity(KZCityDict city) {
	this.city = city;
    }

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;
    }

}
