package com.lapsa.insurance.domain.policy;

import java.util.ArrayList;
import java.util.List;

import com.lapsa.insurance.domain.InsuranceProduct;

public class Policy extends InsuranceProduct {
    private static final long serialVersionUID = 1148321211581313286L;
    private static final int PRIME = 79;
    private static final int MULTIPLIER = PRIME;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

    private List<PolicyDriver> insuredDrivers = new ArrayList<>();
    private List<PolicyVehicle> insuredVehicles = new ArrayList<>();

    public PolicyDriver addDriver(PolicyDriver driver) {
	if (driver == null)
	    throw new NullPointerException("Value must not be null");
	if (insuredDrivers == null)
	    insuredDrivers = new ArrayList<>();
	insuredDrivers.add(driver);
	return driver;
    }

    public PolicyDriver removeDriver(PolicyDriver driver) {
	if (driver == null)
	    throw new NullPointerException("Value must not be null");
	if (insuredDrivers != null)
	    insuredDrivers.remove(driver);
	return driver;
    }

    public PolicyVehicle addVehicle(PolicyVehicle vehicle) {
	if (vehicle == null)
	    throw new NullPointerException("Value must not be null");
	if (insuredVehicles == null)
	    insuredVehicles = new ArrayList<>();
	insuredVehicles.add(vehicle);
	return vehicle;
    }

    public PolicyVehicle removeVehicle(PolicyVehicle vehicle) {
	if (vehicle == null)
	    throw new NullPointerException("Value must not be null");
	if (insuredVehicles != null)
	    insuredVehicles.remove(vehicle);
	return vehicle;
    }

    // GENERATED

    public List<PolicyDriver> getInsuredDrivers() {
	return insuredDrivers;
    }

    public void setInsuredDrivers(List<PolicyDriver> insuredDrivers) {
	this.insuredDrivers = insuredDrivers;
    }

    public List<PolicyVehicle> getInsuredVehicles() {
	return insuredVehicles;
    }

    public void setInsuredVehicles(List<PolicyVehicle> insuredVehicles) {
	this.insuredVehicles = insuredVehicles;
    }
}