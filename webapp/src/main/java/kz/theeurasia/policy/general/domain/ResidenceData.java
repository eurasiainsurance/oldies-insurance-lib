package kz.theeurasia.policy.general.domain;

import kz.theeurasia.esbdproxy.domain.entities.general.CityEntity;

public class ResidenceData {
    private boolean resident;

    private CityEntity city;

    private String address;

    // GENERATED

    public boolean isResident() {
	return resident;
    }

    public void setResident(boolean resident) {
	this.resident = resident;
    }

    public CityEntity getCity() {
	return city;
    }

    public void setCity(CityEntity city) {
	this.city = city;
    }

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;
    }

}
