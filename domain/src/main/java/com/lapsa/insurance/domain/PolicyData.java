package com.lapsa.insurance.domain;

import java.util.List;

public class PolicyData extends BaseEntity<Integer> {
    private static final long serialVersionUID = 1148321211581313286L;

    protected List<InsuredDriverData> insuredDrivers;
    protected List<InsuredVehicleData> insuredVehicles;
    protected CalculationData calculation;

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