package com.lapsa.insurance.domain.policy;

import java.util.List;

import com.lapsa.insurance.domain.BaseEntity;
import com.lapsa.insurance.domain.CalculationData;
import com.lapsa.insurance.domain.InsuredDriverData;
import com.lapsa.insurance.domain.InsuredVehicleData;

public class PolicyData extends BaseEntity<Integer> {
    private static final long serialVersionUID = 1148321211581313286L;
    private static final int PRIME = 79;
    private static final int MULTIPLIER = 79;

    protected List<InsuredDriverData> insuredDrivers;
    protected List<InsuredVehicleData> insuredVehicles;
    protected CalculationData calculation;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

    // GENERATED

    public List<InsuredDriverData> getInsuredDrivers() {
	return insuredDrivers;
    }

    public void setInsuredDrivers(List<InsuredDriverData> insuredDrivers) {
	this.insuredDrivers = insuredDrivers;
    }

    public List<InsuredVehicleData> getInsuredVehicles() {
	return insuredVehicles;
    }

    public void setInsuredVehicles(List<InsuredVehicleData> insuredVehicles) {
	this.insuredVehicles = insuredVehicles;
    }

    public CalculationData getCalculation() {
	return calculation;
    }

    public void setCalculation(CalculationData calculation) {
	this.calculation = calculation;
    }
}