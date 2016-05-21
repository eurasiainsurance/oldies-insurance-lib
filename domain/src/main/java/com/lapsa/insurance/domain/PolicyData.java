package com.lapsa.insurance.domain;

import java.util.ArrayList;
import java.util.List;

public class PolicyData extends BaseDomain<Integer> {

    protected List<InsuredDriverData> insuredDrivers = new ArrayList<>();
    protected List<InsuredVehicleData> insuredVehicles = new ArrayList<>();
    protected CalculationData calculation = new CalculationData();

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