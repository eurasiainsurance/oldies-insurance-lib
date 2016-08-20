package com.lapsa.insurance.domain.policy;

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

    private List<PolicyDriver> insuredDrivers;
    private List<PolicyVehicle> insuredVehicles;

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