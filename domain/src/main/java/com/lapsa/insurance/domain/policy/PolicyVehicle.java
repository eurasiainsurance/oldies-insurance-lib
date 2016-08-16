package com.lapsa.insurance.domain.policy;

import com.lapsa.insurance.domain.Vehicle;
import com.lapsa.insurance.elements.VehicleAgeClass;
import com.lapsa.insurance.elements.VehicleClass;
import com.lapsa.insurance.validation.NotNullValue;
import com.lapsa.insurance.validation.ValidVehicleAgeClass;
import com.lapsa.insurance.validation.ValidVehicleClass;

public class PolicyVehicle extends Vehicle {
    private static final long serialVersionUID = -944934937361936981L;
    private static final int PRIME = 53;
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
    @ValidVehicleClass
    private VehicleClass vehicleClass;

    @NotNullValue
    @ValidVehicleAgeClass
    private VehicleAgeClass vehicleAgeClass;

    private boolean forcedMajorCity;

    private boolean fetched = false;

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
}
