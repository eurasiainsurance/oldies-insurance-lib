package com.lapsa.insurance.domain;

import com.lapsa.insurance.elements.VehicleAgeClass;
import com.lapsa.insurance.elements.VehicleClass;
import com.lapsa.insurance.validation.NotNullValue;
import com.lapsa.insurance.validation.ValidVehicleAgeClass;
import com.lapsa.insurance.validation.ValidVehicleClass;
import com.lapsa.kz.country.KZArea;
import com.lapsa.kz.country.KZCity;
import com.lapsa.kz.country.validators.ValidKZArea;
import com.lapsa.kz.country.validators.ValidKZCity;

public class InsuredVehicleData extends BaseDomain<Integer> {

    @NotNullValue
    @ValidVehicleClass
    private VehicleClass vehicleClass;

    @NotNullValue
    @ValidVehicleAgeClass
    private VehicleAgeClass vehicleAgeClass;

    @NotNullValue
    @ValidKZArea
    private KZArea region;

    @NotNullValue
    @ValidKZCity
    private KZCity city;

    private VehicleData vehicleData = new VehicleData();

    private boolean forcedMajorCity;

    private boolean fetched = false;

    public String getDisplayName() {
	return vehicleData.getDisplayName();
    }

    @Override
    public String toString() {
	return vehicleData.getDisplayName();
    }

    // GENERATED

    public VehicleClass getVehicleClass() {
	return vehicleClass;
    }

    public void setVehicleClass(VehicleClass vehicleClass) {
	this.vehicleClass = vehicleClass;
    }

    public VehicleAgeClass getVehicleAgeClass() {
	return vehicleAgeClass;
    }

    public void setVehicleAgeClass(VehicleAgeClass vehicleAgeClass) {
	this.vehicleAgeClass = vehicleAgeClass;
    }

    public KZArea getRegion() {
	return region;
    }

    public void setRegion(KZArea region) {
	this.region = region;
    }

    public KZCity getCity() {
	return city;
    }

    public void setCity(KZCity city) {
	this.city = city;
    }

    public boolean isForcedMajorCity() {
	return forcedMajorCity;
    }

    public void setForcedMajorCity(boolean forcedMajorCity) {
	this.forcedMajorCity = forcedMajorCity;
    }

    public boolean isFetched() {
	return fetched;
    }

    public void setFetched(boolean fetched) {
	this.fetched = fetched;
    }

    public VehicleData getVehicleData() {
	return vehicleData;
    }

    public void setVehicleData(VehicleData vehicleData) {
	this.vehicleData = vehicleData;
    }
}
